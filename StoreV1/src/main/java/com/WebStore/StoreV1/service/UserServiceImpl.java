package com.WebStore.StoreV1.service;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.User;
import com.WebStore.StoreV1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }


    @Override
    public User createUser(User user) {
        user.setUser_Name(user.getUser_Name());
        user.setEmail(user.getEmail());
        user.setFirst_Name(user.getFirst_Name());
        user.setLast_Name(user.getLast_Name());
        user.setPassword(user.getPassword());
        return userRepo.save(user);

    }


    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }


    @Override
    public Optional<Cart> findCartByUserId(Long id) {
        return userRepo.findCartById(id);
    }
}


