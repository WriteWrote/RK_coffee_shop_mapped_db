package db;

import db.entity.OrderEntity;
import db.entity.OrderLineEntity;
import db.entity.ProductEntity;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DBImitator {
	//todo change later
	private Map<UUID, OrderEntity> ordersTable;
	private Map<UUID, OrderLineEntity> orderLineTable;
	private Map<UUID, ProductEntity> productTable;
	
	public void initEmptyDBState() {
		ordersTable = new HashMap<>();
		orderLineTable = new HashMap<>();
		productTable = new HashMap<>();
	}
	
	public void initDBWithMockData(int nProducts, int nOrders) {
		ordersTable = new HashMap<>();
		orderLineTable = new HashMap<>();
		productTable = new HashMap<>();
		
		for (int i = 0; i < nProducts; i++) {
			UUID generatedUuid = UUID.randomUUID();
			productTable.put(
					generatedUuid,
					new ProductEntity(
							generatedUuid,
							"product" + i,
							"description" + i
					)
			);
		}
		for (int i = 0; i < nOrders; i++) {
			UUID generatedOrderUuid = UUID.randomUUID();
			ordersTable.put(
					generatedOrderUuid,
					new OrderEntity(
							generatedOrderUuid,
							null,
							"88005553535",
							"Ivanov Ivan Ivanovich",
							"Russia",
							"CREATED"
					)
			);
			int randomProductNumber = ThreadLocalRandom.current().nextInt(0, productTable.size());
			UUID generatedOrderLineUUID = UUID.randomUUID();
			orderLineTable.put(
					generatedOrderLineUUID,
					new OrderLineEntity(
							generatedOrderLineUUID,
							generatedOrderUuid,
							Objects.requireNonNull(productTable.entrySet().stream().skip(randomProductNumber).findFirst().orElse(null)).getValue().getUUID(),
							ThreadLocalRandom.current().nextInt(0, 10 + 1)
					)
			);
		}
	}
	
	public Map<UUID, OrderEntity> getOrdersTable() {
		return ordersTable;
	}
	
	public Map<UUID, OrderLineEntity> getOrderLineTable() {
		return orderLineTable;
	}
	
	public Map<UUID, ProductEntity> getProductTable() {
		return productTable;
	}
}
