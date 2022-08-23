package net.codejava.io.repository;

import net.codejava.io.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    ProductEntity findByProductId(String productId);
}
