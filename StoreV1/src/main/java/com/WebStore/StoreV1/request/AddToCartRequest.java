package com.WebStore.StoreV1.request;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.CartItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddToCartRequest
{
    private Cart cart;
    private CartItem cartItem;
}
