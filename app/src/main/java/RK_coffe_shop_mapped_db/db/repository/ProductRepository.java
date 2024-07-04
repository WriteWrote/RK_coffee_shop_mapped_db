package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {
}
