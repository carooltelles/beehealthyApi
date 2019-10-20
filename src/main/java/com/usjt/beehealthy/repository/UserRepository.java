package com.usjt.beehealthy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usjt.beehealthy.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmailAndPasswordAndType(String email, String password, String type);
	
}
