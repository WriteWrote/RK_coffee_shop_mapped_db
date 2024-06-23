package controller;

import model.dto.ProductDto;
import service.ProductService;

import java.util.UUID;

public class ProductController {
	private ProductService service;
	
	public void create(ProductDto dto) {
		try {    //todo toString
			//todo and for entity too
			ProductDto createdDto = service.create(dto);
			System.out.println(new Response<>(200, "Product entity is created", createdDto));
		} catch (Exception ex) {
			System.out.println(new Response<>(500, ex.getMessage(), ex));
		}
	}
	
	public void delete(UUID uuid) {
		try {
			service.delete(uuid);
			System.out.println(new Response<>(200, "Product entity is deleted", null));
		} catch (Exception ex) {
			System.out.println(new Response<>(500, ex.getMessage(), ex));
		}
	}
	
	public void update(ProductDto dto) {
		try {
			ProductDto updatedDto = service.update(dto);
			System.out.println(new Response<>(200, "Product entity is updated", updatedDto));
		} catch (Exception ex) {
			System.out.println(new Response<>(500, ex.getMessage(), ex));
		}
	}
	
	public void getById(UUID uuid) {
		try {
			ProductDto dto = service.getById(uuid);
			System.out.println(new Response<>(200, "Product entity is found", dto));
		} catch (Exception ex) {
			System.out.println(new Response<>(500, ex.getMessage(), ex));
		}
	}
	
	public void getAll() {
		System.out.println(new Response<>(200, "List of all Products", service.getAll()));
	}
}
