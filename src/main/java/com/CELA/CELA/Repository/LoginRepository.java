package com.CELA.CELA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CELA.CELA.Model.User;

public interface LoginRepository extends JpaRepository<User,Long>{
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(String email);
}
