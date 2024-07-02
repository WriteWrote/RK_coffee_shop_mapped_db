package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.ProductRepository;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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
		repository.delete(uuid);
	}
	
	public ProductDto update(ProductDto dto) throws Exception {
		return mapper.fromEntity(repository.update(mapper.toEntity(dto)));
	}
	
	public ProductDto getById(UUID uuid) throws Exception {
		return mapper.fromEntity(repository.findById(uuid));
	}
	
	public List<ProductDto> getAll() {
		return repository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
	}
}
