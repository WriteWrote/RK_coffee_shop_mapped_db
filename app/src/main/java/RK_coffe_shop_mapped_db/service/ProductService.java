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
		return productMapper.fromEntity(productRepository.save(productMapper.toEntity(dto)));
	}
	
	public void delete(UUID uuid) throws Exception {
		if (!productRepository.existsById(uuid)) {
			throw new Exception("No product to delete");
		}
		productRepository.deleteById(uuid);
	}
	
	public ProductDto update(ProductDto dto) throws Exception {
		if (!productRepository.existsById(dto.getUuid())) {
			throw new Exception("No product to update");
		}
		return productMapper.fromEntity(productRepository.save(productMapper.toEntity(dto)));
	}
	
	public ProductDto getById(UUID uuid) {
		return productMapper.fromEntity(productRepository.findById(uuid).orElseThrow());
	}
	
	public List<ProductDto> getAll() {
		return StreamSupport.stream(productRepository.findAll().spliterator(), false)
			.map(productMapper::fromEntity)
			.collect(Collectors.toList());
	}
}
