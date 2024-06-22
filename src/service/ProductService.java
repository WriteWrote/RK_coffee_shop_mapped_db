package service;

import db.repository.ProductRepository;
import model.dto.ProductDto;
import model.mapper.ProductMapper;

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
	
	public void deleteProduct() {
		//todo not yet implemented
	}
	
	public void updateProduct() {
		//todo not yet implemented
	}
}
