package service;

import db.repository.ProductRepository;
import model.Response;
import model.dto.ProductDto;
import model.mapper.ProductMapper;

import java.util.UUID;

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
			return new Response<>(500, "Product entity is not created", null);
		}
	}
	
	public void deleteProduct(UUID uuid) throws Exception {
		repository.delete(uuid);
		try {
			
			return new Response<>(200, "Product entity is created", createdDto);
		} catch (Exception ex) {
			return new Response<>(500, "Product entity is not created", null);
		}
	}
	
	public void updateProduct(ProductDto dto) throws Exception {
		repository.update(mapper.toEntity(dto));
	}
	
	public ProductDto getById(UUID uuid) throws Exception {
		return mapper.fromEntity(repository.findById(uuid));
	}
}
