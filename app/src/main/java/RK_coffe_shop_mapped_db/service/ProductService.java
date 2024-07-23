package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.ProductRepository;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto create(ProductDto dto) {
        if (dto.getId() == null) {
            logger.warn("Warning: " + dto.getClass() + " has empty id. This empty id field was randomized.");
            dto.setId(UUID.randomUUID());
        }
        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    public void delete(UUID id) throws Exception {
        if (!productRepository.existsById(id)) {
            logger.error("Delete product error: no product exists with this id.");
            throw new Exception("No product to delete");
        }
        productRepository.delete(id);
    }

    public ProductDto update(ProductDto dto) throws Exception {
        if (!productRepository.existsById(dto.getId())) {
            logger.error("Update product error: no product exists with this id.");
            throw new Exception("No product to update");
        }
        var dbEntity = productRepository.findById(dto.getId()).orElseThrow();
        return productMapper.toDto(productRepository.update(productMapper.merge(dbEntity, dto)));
    }

    public ProductDto getById(UUID id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow());
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
