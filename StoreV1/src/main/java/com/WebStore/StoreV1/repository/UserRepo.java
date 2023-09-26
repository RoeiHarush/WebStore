package com.WebStore.StoreV1.repository;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <User,Long>
{
    Optional<Cart> findCartById(Long id);


}
