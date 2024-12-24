package com.CELA.CELA.Repository;
import com.CELA.CELA.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}