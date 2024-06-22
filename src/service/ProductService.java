package service;

import db.repository.ProductRepository;
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
	
	public void createProduct(ProductDto dto) {  //todo decide whether use Responce or Dto
		repository.save(mapper.toEntity(dto));
	}
	
	public void deleteProduct(UUID uuid) throws Exception {	//todo instead of throwing exception use try catch and return response
		repository.delete(uuid);
	}
	
	public void updateProduct(ProductDto dto) throws Exception {
		repository.update(mapper.toEntity(dto));
	}
	
	public ProductDto getById(UUID uuid) throws Exception {
		return mapper.fromEntity(repository.findById(uuid));
	}
}
