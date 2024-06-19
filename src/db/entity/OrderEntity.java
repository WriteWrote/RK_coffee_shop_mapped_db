package db.entity;

import java.util.UUID;

public class OrderEntity {
    private final UUID id;
    private final UUID customerId;
    private final String customerPhone;
    private final String customerFIO;
    private final String address;
    private final String status;

    public OrderEntity(UUID id, UUID customerId, String customerPhone, String customerFIO, String address, String status) {
        this.id = id;
        this.customerId = customerId;
        this.customerPhone = customerPhone;
        this.customerFIO = customerFIO;
        this.address = address;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerFIO() {
        return customerFIO;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }
}
