package db.entity;

import java.util.UUID;

public class ProductEntity extends Entity{
    private final String name;
    private final String description;

    public ProductEntity(UUID uuid, String name, String description) {
        setId(uuid);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
