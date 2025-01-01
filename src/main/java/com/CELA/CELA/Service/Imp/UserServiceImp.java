package com.CELA.CELA.Service.Imp;

import com.CELA.CELA.Model.User;
import com.CELA.CELA.Repository.UserRepository;
import com.CELA.CELA.Service.UserService;
import com.CELA.CELA.Exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImp.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean addUser(User user) {
        try {
        	System.out.println(user.getIsApproved());
            userRepository.save(user);
            logger.info("User added successfully: {}", user);
            return true;
        } catch (Exception ex) {
            logger.error("Error adding user: {}", ex.getMessage());
            throw new RuntimeException("Failed to add user", ex);
        }
    }

    @Override
    public User getSingleUserDetails(Long id) {
        logger.info("Fetching details for user ID: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", id);
                    return new ResourceNotFoundException("User not found with ID: " + id);
                });
    }

    @Override
    public List<User> getAllUserDetails() {
        try {
            List<User> users = userRepository.findAll();
            logger.info("Fetched all user details successfully.");
            return users;
        } catch (Exception ex) {
            logger.error("Error fetching all users: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch user details", ex);
        }
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("User not found for update with ID: {}", id);
                        return new ResourceNotFoundException("User not found with ID: " + id);
                    });

            // Update fields
           existingUser.setFirstName(user.getFirstName());
           existingUser.setLastName(user.getLastName());
           existingUser.setEmail(user.getEmail());
           existingUser.setMobileNo(user.getMobileNo());
           existingUser.setPassword(user.getPassword());
            userRepository.save(existingUser);
            logger.info("User updated successfully: {}", existingUser);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating user with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update user", ex);
        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("User not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("User not found with ID: " + id);
                    });

            userRepository.delete(existingUser);
            logger.info("User deleted successfully with ID: {}", id);
            return true;
        } catch (Exception ex) {
            logger.error("Error deleting user with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to delete user", ex);
        }
    }

	@Override
	public List<User> getAllUserDetailsByRole(String role) {
		try {
            List<User> users = userRepository.findUserByRole(role);
            logger.info("Fetched all user details successfully.");
            return users;
        } catch (Exception ex) {
            logger.error("Error fetching all users: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch user details", ex);
        }
	}

	@Override
	public List<User> getAllUserDetailsByIsApproved(boolean flag) {
		try {
            List<User> users = userRepository.findUserByIsApproved(flag);
            logger.info("Fetched all user details successfully.");
            return users;
        } catch (Exception ex) {
            logger.error("Error fetching all users: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch user details", ex);
        }
	}

	@Override
	public Boolean approvedUser(Long id) {
		try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("User not found for update with ID: {}", id);
                        return new ResourceNotFoundException("User not found with ID: " + id);
                    });

            // Update fields
            existingUser.setApproved(true);
            userRepository.save(existingUser);
            logger.info("User updated successfully: {}", existingUser);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating user with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update user", ex);
        }
	}

	@Override
	public String getNameByuserId(Long id) {
		logger.info("Fetching name for user ID: {}", id);
        return userRepository.getNameByuserId(id);
                
	}
}

