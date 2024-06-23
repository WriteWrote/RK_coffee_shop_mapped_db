import db.DBProvider;
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
		userRepository.setTable(new DBProvider<UserEntity>().initEmptyTable());
		
		ProductRepository productRepository = new ProductRepository();
		productRepository.setTable(new DBProvider<ProductEntity>().initEmptyTable());
		
		OrderRepository orderRepository = new OrderRepository();
		orderRepository.setTable(new DBProvider<OrderEntity>().initEmptyTable());
		
		OrderLineRepository orderLineRepository = new OrderLineRepository();
		orderLineRepository.setTable(new DBProvider<OrderLineEntity>().initEmptyTable());
		
		
	}
}