package service;

import db.repository.ProductRepository;
import model.dto.ProductDto;
import model.mapper.ProductMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductService {
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
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
