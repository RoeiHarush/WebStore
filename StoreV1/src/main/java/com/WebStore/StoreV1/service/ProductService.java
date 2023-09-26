package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Product;
import com.WebStore.StoreV1.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    public Optional<Product> findById(Long id);
    Product createProduct(Product product);
    public List<Product> findAllProducts();
    void deleteProductById(Long id);


}
