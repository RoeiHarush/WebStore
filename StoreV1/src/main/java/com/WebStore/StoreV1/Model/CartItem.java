package com.WebStore.StoreV1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cart_item")
public class CartItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    public Product product;


    @ManyToOne
   @JoinColumn(name = "cart_id")
    @JsonIgnore
    public Cart cart;

    public int quantity;

    public CartItem(Product product,int quantity)
    {
        this.product= product;
        this.quantity = quantity;

    }


}
