package com.CELA.CELA.Service;

import java.util.List;

import com.CELA.CELA.Model.User;

public interface UserService {
    Boolean addUser(User user);
    User getSingleUserDetails(Long id);
    List<User> getAllUserDetails();
    List<User> getAllUserDetailsByRole(String role);
    List<User> getAllUserDetailsByIsApproved(boolean flag);
    Boolean approvedUser(Long id);
    Boolean updateUser(Long id,User user);
    Boolean deleteUser(Long id);
    String getNameByuserId(Long id);
}
