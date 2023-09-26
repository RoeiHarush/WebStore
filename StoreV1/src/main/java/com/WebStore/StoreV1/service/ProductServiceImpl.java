package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Product;
import com.WebStore.StoreV1.Model.User;
import com.WebStore.StoreV1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepo repo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.repo = productRepo;
    }
    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id);

    }

    @Override
    public Product createProduct(Product product) {
     product.setCategory(product.getCategory());
     product.setName(product.getName());
     product.setDescription(product.getDescription());
     product.setPrice(product.getPrice());
        return repo.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return repo.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        repo.deleteById(id);
    }

}

