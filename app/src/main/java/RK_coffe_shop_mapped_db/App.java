package RK_coffe_shop_mapped_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
