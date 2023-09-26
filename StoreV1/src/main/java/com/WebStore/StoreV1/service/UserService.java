package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService
{
    User createUser(User user);
    void deleteUserById(Long id);
    Optional<Cart> findCartByUserId(Long id);
    Optional<User> getUserById(Long userId);
    public List<User> findAllUsers();

}
