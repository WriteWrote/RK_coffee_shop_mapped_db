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
	
	public Response<ProductDto> createProduct(ProductDto dto) {
		try {
			ProductDto createdDto = mapper.fromEntity(repository.save(mapper.toEntity(dto)));
			return new Response<>(200, "Product entity is created", createdDto);
		} catch (Exception ex) {
			return new Response<>(500, ex.getMessage(), null);
		}
	}
	
	public Response<ProductDto> deleteProduct(UUID uuid) {
		try {
			repository.delete(uuid);
			return new Response<>(200, "Product entity is deleted", null);
		} catch (Exception ex) {
			return new Response<>(500, ex.getMessage(), null);
		}
	}
	
	public Response<ProductDto> updateProduct(ProductDto dto) {
		try {
			ProductDto updatedDto = mapper.fromEntity(repository.update(mapper.toEntity(dto)));
			return new Response<>(200, "Product entity is updated", updatedDto);
		} catch (Exception ex) {
			return new Response<>(500, ex.getMessage(), null);
		}
	}
	
	public Response<ProductDto> getById(UUID uuid) {
		try {
			return new Response<>(200, "Product entity is found", mapper.fromEntity(repository.findById(uuid)));
		} catch (Exception ex) {
			return new Response<>(500, ex.getMessage(), null);
		}
	}
	
	public List<ProductDto> getAll() {
		return repository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
	}
}
