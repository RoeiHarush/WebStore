package com.WebStore.StoreV1.controller;

import com.WebStore.StoreV1.Model.Cart;
import com.WebStore.StoreV1.Model.User;
import com.WebStore.StoreV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) { 
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {

        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}/cart")
    public ResponseEntity<Cart> getUserCart(@PathVariable Long userId) {
        Optional<Cart> cartOptional = userService.findCartByUserId(userId);

        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            return ResponseEntity.ok(cart);
        }
        else

            return ResponseEntity.notFound().build();

    }

}
