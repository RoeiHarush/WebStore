package com.WebStore.StoreV1.repository;

import com.WebStore.StoreV1.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long>
{

}
