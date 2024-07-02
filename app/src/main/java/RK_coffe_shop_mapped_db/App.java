package RK_coffe_shop_mapped_db;

import RK_coffe_shop_mapped_db.controller.OrderController;
import RK_coffe_shop_mapped_db.controller.ProductController;
import RK_coffe_shop_mapped_db.controller.UserController;
import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.db.DBFactory;
import RK_coffe_shop_mapped_db.db.entity.OrderEntity;
import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import RK_coffe_shop_mapped_db.db.repository.OrderLineRepository;
import RK_coffe_shop_mapped_db.db.repository.OrderRepository;
import RK_coffe_shop_mapped_db.db.repository.ProductRepository;
import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.OrderService;
import RK_coffe_shop_mapped_db.service.ProductService;
import RK_coffe_shop_mapped_db.service.UserService;
import RK_coffe_shop_mapped_db.service.mapper.CreateUserMapper;
import RK_coffe_shop_mapped_db.service.mapper.OrderLineMapper;
import RK_coffe_shop_mapped_db.service.mapper.OrderMapper;
import RK_coffe_shop_mapped_db.service.mapper.ProductMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
//	public static void main(String[] args) {
//
//		System.out.println("Hello world!");
//
//		UserRepository userRepository = new UserRepository();
//		userRepository.setTable(new DBFactory<UserEntity>().initEmptyTable());
//		UserService userService = new UserService(userRepository, new CreateUserMapper());
//		UserController userController = new UserController(userService, new ExceptionHandler<>());
//
//		ProductRepository productRepository = new ProductRepository();
//		productRepository.setTable(new DBFactory<ProductEntity>().initEmptyTable());
//		ProductService productService = new ProductService(productRepository, new ProductMapper());
//		ProductController productController = new ProductController(productService, new ExceptionHandler<>());
//
//		OrderLineRepository orderLineRepository = new OrderLineRepository();
//		orderLineRepository.setTable(new DBFactory<OrderLineEntity>().initEmptyTable());
//
//		OrderRepository orderRepository = new OrderRepository();
//		orderRepository.setTable(new DBFactory<OrderEntity>().initEmptyTable());
//		OrderService orderService = new OrderService(orderRepository, orderLineRepository, new OrderMapper(), new OrderLineMapper());
//		OrderController orderController = new OrderController(orderService, new ExceptionHandler<>());
//
//		System.out.println(userController.create(new CreateUserDto(UUID.randomUUID(), "somelogin", "somepassword")));
//		System.out.println(productController.create(new ProductDto(UUID.randomUUID(), "coffee", "tasty coffee")));
//		System.out.println(productController.create(new ProductDto(UUID.randomUUID(), "buiscuit", "tasty buiscuit")));
//		var productForDeletion = (ProductDto) productController.create(new ProductDto(UUID.randomUUID(), "errorProduct", "")).getDto();
//
//		printAllProducts(productController);
//
//		productController.delete(productForDeletion.getUuid());
//
//		printAllProducts(productController);
//
//		// представим, что мы заранее знаем айди товаров для заказа
//		var listOfProductsForOrder = productRepository.findAll().stream().map(ProductEntity::getUUID).toList();
//		var mapOfProductsForOrder = new HashMap<UUID, Integer>();
//		listOfProductsForOrder.forEach(it -> mapOfProductsForOrder.put(it, 1));
//
//		var responseOrderCreate = orderController.create(new OrderDto(
//				UUID.randomUUID(),
//				null,
//				"88005553535",
//				"Ivanov Ivan Ivanovich",
//				"Prekrasnoe dalyoko",
//				"CREATED",
//				mapOfProductsForOrder
//		));
//		System.out.println(responseOrderCreate);
//		System.out.println(((OrderDto) responseOrderCreate.getDto()).getProducts());
//	}
//
//	private static void printAllProducts(ProductController productController) {
//		System.out.println(productController.getAll());
//		System.out.println("\nList of all products: ");
//		for (ProductDto productDto : (List<ProductDto>) productController.getAll().getDto()) {
//			System.out.println(productDto.getUuid() + "; " + productDto.getName() + "; " + productDto.getDescription());
//		}
//		System.out.println();
//	}
}