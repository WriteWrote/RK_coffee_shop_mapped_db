package db;

import db.entity.OrderEntity;
import db.entity.OrderLineEntity;
import db.entity.ProductEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DBImitator {
    private Map<UUID, OrderEntity> ordersTable;
    private Map<UUID, OrderLineEntity> orderLineTable;
    private Map<UUID, ProductEntity> productTable;

    public void initDBState() {
        ordersTable = new HashMap<>();
        orderLineTable = new HashMap<>();
        productTable = new HashMap<>();
    }

    //todo add mockEntityCreation methods

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
