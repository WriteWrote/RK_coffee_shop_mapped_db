import controller.OrderController;
import controller.ProductController;
import controller.UserController;
import controller.handler.ExceptionHandler;
import db.DBFactory;
import db.entity.OrderEntity;
import db.entity.OrderLineEntity;
import db.entity.ProductEntity;
import db.entity.UserEntity;
import db.repository.OrderLineRepository;
import db.repository.OrderRepository;
import db.repository.ProductRepository;
import db.repository.UserRepository;
import dto.CreateUserDto;
import dto.OrderDto;
import dto.ProductDto;
import dto.UserDto;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.mapper.*;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		UserRepository userRepository = new UserRepository();
		userRepository.setTable(new DBFactory<UserEntity>().initEmptyTable());
		UserService userService = new UserService(userRepository, new CreateUserMapper());
		UserController userController = new UserController(userService, new ExceptionHandler<>());
		
		ProductRepository productRepository = new ProductRepository();
		productRepository.setTable(new DBFactory<ProductEntity>().initEmptyTable());
		ProductService productService = new ProductService(productRepository, new ProductMapper());
		ProductController productController = new ProductController(productService, new ExceptionHandler<>());
		
		OrderLineRepository orderLineRepository = new OrderLineRepository();
		orderLineRepository.setTable(new DBFactory<OrderLineEntity>().initEmptyTable());
		
		OrderRepository orderRepository = new OrderRepository();
		orderRepository.setTable(new DBFactory<OrderEntity>().initEmptyTable());
		OrderService orderService = new OrderService(orderRepository, orderLineRepository, new OrderMapper(), new OrderLineMapper());
		OrderController orderController = new OrderController(orderService, new ExceptionHandler<>());
		
		System.out.println(userController.create(new CreateUserDto(UUID.randomUUID(), "somelogin", "somepassword")));
		System.out.println(productController.create(new ProductDto(UUID.randomUUID(), "coffee", "tasty coffee")));
		System.out.println(productController.create(new ProductDto(UUID.randomUUID(), "buiscuit", "tasty buiscuit")));
		var productForDeletion = (ProductDto) productController.create(new ProductDto(UUID.randomUUID(), "errorProduct", "")).getDto();
		
		printAllProducts(productController);
		
		productController.delete(productForDeletion.getUuid());
		
		printAllProducts(productController);
		
		// представим, что мы заранее знаем айди товаров для заказа
		var listOfProductsForOrder = productRepository.findAll().stream().map(ProductEntity::getUUID).collect(Collectors.toList());
		var mapOfProductsForOrder = new HashMap<UUID, Integer>();
		listOfProductsForOrder.forEach(it -> mapOfProductsForOrder.put(it, 1));
		
		var responseOrderCreate = orderController.create(new OrderDto(
				UUID.randomUUID(),
				null,
				"88005553535",
				"Ivanov Ivan Ivanovich",
				"Prekrasnoe dalyoko",
				"CREATED",
				mapOfProductsForOrder
		));
		System.out.println(responseOrderCreate);
		System.out.println(((OrderDto) responseOrderCreate.getDto()).getProducts());
	}
	
	private static void printAllProducts(ProductController productController) {
		System.out.println(productController.getAll());
		System.out.println("\nList of all products: ");
		for (ProductDto productDto : (List<ProductDto>) productController.getAll().getDto()) {
			System.out.println(productDto.getUuid() + "; " + productDto.getName() + "; " + productDto.getDescription());
		}
		System.out.println();
	}
	
	
}
