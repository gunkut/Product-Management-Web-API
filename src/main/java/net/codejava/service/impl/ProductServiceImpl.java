package net.codejava.service.impl;

import net.codejava.exceptions.ProductNotFoundException;
import net.codejava.io.entity.ProductEntity;
import net.codejava.io.repository.ProductRepository;
import net.codejava.service.ProductService;
import net.codejava.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Utils utils;

    @Override
    public List<ProductEntity> listAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public void deleteProduct(String productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId);

         if (productEntity == null) {
            throw new ProductNotFoundException("Product with Id: " + productId + " not found");
         }
         productRepository.delete(productEntity);
    }

    @Override
    public void AddNewProduct(ProductEntity productEntity) {

        String publicProductId = utils.generateProductId(15);
        productEntity.setProductId(publicProductId);
        productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getProduct(String productId) throws ProductNotFoundException {
        ProductEntity productEntity = productRepository.findByProductId(productId);

        if (productEntity != null) {
            return productEntity;
        } else {
            throw new ProductNotFoundException("Product with id:" + productId + " not found");
        }
    }
}
