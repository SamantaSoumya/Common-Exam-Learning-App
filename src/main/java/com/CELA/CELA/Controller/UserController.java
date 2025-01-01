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
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
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
    
    @GetMapping("/admin/{role}")
    public ResponseEntity<List<User>> getAllUsersByRole(@PathVariable String role) {
        List<User> users = userService.getAllUserDetailsByRole(role);
        logger.info("Fetched all users.");
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/admin/isApproved/{flag}")
    public ResponseEntity<List<User>> getAllUsersByIsApproved(@PathVariable boolean flag) {
        List<User> users = userService.getAllUserDetailsByIsApproved(flag);
        logger.info("Fetched all users.");
        return ResponseEntity.ok(users);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> approvedUser(@PathVariable Long id) {
        userService.approvedUser(id);
        logger.info("Updated user for ID: {}", id);
        return ResponseEntity.ok("User updated successfully");
    }
    @GetMapping("/student/{id}")
    public ResponseEntity <String> getNameByuserId(@PathVariable Long id) {
        String name = userService.getNameByuserId(id);
        logger.info("Fetched user name succesfully");
        return ResponseEntity.ok(name);
    }
}
