package net.codejava.service;

import net.codejava.io.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService{

    List<ProductEntity> listAll();
    void deleteProduct(String productId);
    void AddNewProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
