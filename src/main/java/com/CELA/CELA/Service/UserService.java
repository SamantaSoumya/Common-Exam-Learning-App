package com.CELA.CELA.Service;

import java.util.List;

import com.CELA.CELA.Model.User;

public interface UserService {
    Boolean addUser(User user);
    User getSingleUserDetails(Long id);
    List<User> getAllUserDetails();
    Boolean updateUser(Long id,User user);
    Boolean deleteUser(Long id);
}
