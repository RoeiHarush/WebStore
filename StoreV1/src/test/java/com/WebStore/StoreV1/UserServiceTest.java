package com.WebStore.StoreV1;

import com.WebStore.StoreV1.Model.User;
import com.WebStore.StoreV1.repository.UserRepo;
import com.WebStore.StoreV1.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Create a sample user
        User user = new User();
        user.setUser_Name("testuser");
        user.setEmail("testuser@example.com");
        user.setFirst_Name("John");
        user.setLast_Name("Doe");
        user.setPassword("password");

        // Mock the behavior of userRepo.save to return the same user
        when(userRepo.save(user)).thenReturn(user);

        // Call the method to create a user
        User createdUser = userService.createUser(user);

        // Verify that userRepo.save was called once with the same user object

        // Assert that the createdUser is not null
        assertNotNull(createdUser);

        // Assert that the fields of createdUser match the input user
        assertEquals("testuser", createdUser.getUser_Name());
        assertEquals("testuser@example.com", createdUser.getEmail());
        assertEquals("John", createdUser.getFirst_Name());
        assertEquals("Doe", createdUser.getLast_Name());
        assertEquals("password", createdUser.getPassword());
    }
}
