package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.ProductRepository;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	public ProductDto create(ProductDto dto) {
		if (dto.getId() == null)
			dto.setId(UUID.randomUUID());
		return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
	}

	public void delete(UUID id) throws Exception {
		if (!productRepository.existsById(id)) {
			throw new Exception("No product to delete");
		}
		productRepository.delete(id);
	}

	public ProductDto update(ProductDto dto) throws Exception {
		if (!productRepository.existsById(dto.getId())) {
			throw new Exception("No product to update");
		}
		return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
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
