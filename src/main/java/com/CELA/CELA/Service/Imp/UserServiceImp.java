package com.CELA.CELA.Service.Imp;

import com.CELA.CELA.Model.User;
import com.CELA.CELA.Repository.UserRepository;
import com.CELA.CELA.Service.UserService;
import com.CELA.CELA.Exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImp.class);

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Boolean addUser(User user) {
        try {
        	System.out.println(user.getIsApproved());
            userRepository.save(user);
            logger.info("User added successfully: {}", user);
        	 UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                     .setEmail(user.getEmail())
                     .setPassword(user.getPassword())
                     .setEmailVerified(false);

             FirebaseAuth.getInstance().createUser(request);

             // Send email with password
             sendEmail(user.getEmail(), user.getPassword());
             sendEmailAdmin(user.getEmail(),user.getUserId());
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
	private void sendEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome! Your Account Password");
        message.setText("Your password is: " + password);
        mailSender.send(message);
    }
	private void sendEmailAdmin(String email,Long id) {
        SimpleMailMessage message = new SimpleMailMessage();
        String adminEmail = "cela5202@gmail.com";
        message.setTo(adminEmail);
        message.setSubject("New Organisation added with the User Id" + id + " and email is " + email);
        mailSender.send(message);
    }
}
class UserRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

