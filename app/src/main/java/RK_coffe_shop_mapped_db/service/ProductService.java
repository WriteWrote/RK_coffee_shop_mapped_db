package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.ProductRepository;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	@Autowired
	public ProductService(ProductRepository repository, ProductMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ProductDto create(ProductDto dto) {
		return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
	}
	
	public void delete(UUID uuid) throws Exception {
		if (repository.existsById(uuid))
			repository.deleteById(uuid);
		else throw new Exception("No product to delete");
	}
	
	public ProductDto update(ProductDto dto) throws Exception {
		if (repository.existsById(dto.getUuid()))
			return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
		else throw new Exception("No product to update");
	}
	
	public ProductDto getById(UUID uuid) {
		return mapper.fromEntity(repository.findById(uuid).orElseThrow());
	}
	
	public List<ProductDto> getAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false)
				.map(mapper::fromEntity)
				.collect(Collectors.toList());
	}
}
