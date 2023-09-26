package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.CartItem;
import com.WebStore.StoreV1.Model.Product;
import com.WebStore.StoreV1.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepository;

    @Autowired
    public CartServiceImpl(CartRepo cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

//    @Override
//    public void removeItemFromCart(Long Id) {
//        return cartRepository.findById(Id)
//    }


    @Override
    public void addProductToCart(Cart cart, Product product, int quantity) {

        CartItem existingCartItem = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().equals(product))
                .findFirst()
                .orElse(null);


        if (existingCartItem != null) {

            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
        } else {

            CartItem newCartItem = new CartItem(product, quantity);
            newCartItem.setCart(cart);
            cart.getCartItems().add(newCartItem);
        }

        cartRepository.save(cart);
    }



}

