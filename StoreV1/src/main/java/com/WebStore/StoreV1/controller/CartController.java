package com.WebStore.StoreV1.controller;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.CartItem;
import com.WebStore.StoreV1.Model.Product;
import com.WebStore.StoreV1.request.AddToCartRequest;
import com.WebStore.StoreV1.service.CartService;
import com.WebStore.StoreV1.service.ProductService;
import com.WebStore.StoreV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {


    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public ResponseEntity<String> addProductToCart(@RequestParam("cartId") Long cartId,
                                                   @RequestParam("productId") Long productId,
                                                   @RequestParam("quantity") int quantity) {
        Cart cart = cartService.getCartById(cartId); // Retrieve the user's cart, you'll need to implement this
        Optional<Product> productOptional = productService.findById(productId);
        productOptional.ifPresent(product -> {
            cartService.addProductToCart(cart, product, quantity);
        });


        return ResponseEntity.ok("Product added to cart successfully");
    }



    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
    Cart cart = cartService.getCartById(cartId);
            return ResponseEntity.ok(cart);
        }
    }

