package com.WebStore.StoreV1.controller;

import com.WebStore.StoreV1.Model.Product;
import com.WebStore.StoreV1.Model.User;
import com.WebStore.StoreV1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping ("/{ProductId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long ProductId)
    {
        Optional<Product> product1 = productService.findById(ProductId);
        if (product1.isPresent()) {
            Product product = product1.get();
            return ResponseEntity.ok(product);
        }
        else return ResponseEntity.notFound().build();
    }



    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct (@RequestParam Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }




}
