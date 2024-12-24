package com.CELA.CELA.Controller;

import com.CELA.CELA.Model.User;
import com.CELA.CELA.Service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Add a new user
     */
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        logger.info("User added: {}", user);
        return ResponseEntity.ok("User added successfully");
    }

    /**
     * Get details of a user by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long id) {
        User user = userService.getSingleUserDetails(id);
        logger.info(user);
        return ResponseEntity.ok(user);
    }

    /**
     * Get all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUserDetails();
        logger.info("Fetched all users.");
        return ResponseEntity.ok(users);
    }

    /**
     * Update details of a user by ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        logger.info("Updated user for ID: {}", id);
        return ResponseEntity.ok("User updated successfully");
    }

    /**
     * Delete a user by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        logger.info("Deleted user for ID: {}", id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
