import db.DBFactory;
import db.entity.OrderEntity;
import db.entity.OrderLineEntity;
import db.entity.ProductEntity;
import db.entity.UserEntity;
import db.repository.OrderLineRepository;
import db.repository.OrderRepository;
import db.repository.ProductRepository;
import db.repository.UserRepository;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		UserRepository userRepository = new UserRepository();
		userRepository.setTable(new DBFactory<UserEntity>().initEmptyTable());
		
		ProductRepository productRepository = new ProductRepository();
		productRepository.setTable(new DBFactory<ProductEntity>().initEmptyTable());
		
		OrderRepository orderRepository = new OrderRepository();
		orderRepository.setTable(new DBFactory<OrderEntity>().initEmptyTable());
		
		OrderLineRepository orderLineRepository = new OrderLineRepository();
		orderLineRepository.setTable(new DBFactory<OrderLineEntity>().initEmptyTable());
		
		Utils.printInstruction();
		Utils.play();
//		UserEntity entity = new UserEntity(UUID.randomUUID(), "somelogin", "somepassword");
//		System.out.println(entity);
	}
}
