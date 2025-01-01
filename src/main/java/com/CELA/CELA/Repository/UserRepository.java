package com.CELA.CELA.Repository;
import com.CELA.CELA.Model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
	@Query("SELECT u FROM User u WHERE u.role = :role")
	List<User> findUserByRole(String role);
	
	@Query("SELECT u FROM User u WHERE u.isApproved = :flag")
	List<User> findUserByIsApproved(boolean flag);
	
	@Query("UPDATE User u SET u.isApproved = true WHERE u.id = :userId")
	Boolean approveUser(Long userId);
	
	@Query("SELECT  u.firstName From User u where u.userId = :userId")
	String getNameByuserId(Long userId);
	
}