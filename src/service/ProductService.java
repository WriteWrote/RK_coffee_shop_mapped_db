package service;

import db.repository.ProductRepository;
import model.Response;
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
	
	public ProductDto createProduct(ProductDto dto) {
		return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
//		try {
//			ProductDto createdDto = mapper.fromEntity();
//			return new Response<>(200, "Product entity is created", createdDto);
//		} catch (Exception ex) {
//			return new Response<>(500, ex.getMessage(), null);
//		}
	}
	
	public void deleteProduct(UUID uuid) throws Exception {
		repository.delete(uuid);
//		try {
//
//			return new Response<>(200, "Product entity is deleted", null);
//		} catch (Exception ex) {
//			return new Response<>(500, ex.getMessage(), null);
//		}
	}
	
	public ProductDto updateProduct(ProductDto dto) throws Exception {
		return mapper.fromEntity(repository.update(mapper.toEntity(dto)));
//		try {
//			ProductDto updatedDto = ;
//			return new Response<>(200, "Product entity is updated", updatedDto);
//		} catch (Exception ex) {
//			return new Response<>(500, ex.getMessage(), null);
//		}
	}
	
	public ProductDto getById(UUID uuid) throws Exception {
		return mapper.fromEntity(repository.findById(uuid));
//		try {
//			return new Response<>(200, "Product entity is found", );
//		} catch (Exception ex) {
//			return new Response<>(500, ex.getMessage(), null);
//		}
	}
	
	public List<ProductDto> getAll() {
		return repository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
	}
}
