package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.CartItem;
import com.WebStore.StoreV1.Model.Product;
import org.springframework.stereotype.Service;

@Service
public interface CartService
{
    void addProductToCart(Cart cart, Product product, int quantity);
    public Cart getCartById(Long cartId);
//    public void removeItemFromCart(Long Id);

}