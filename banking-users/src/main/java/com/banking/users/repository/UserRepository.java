package com.banking.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.users.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findOneByUserName(String userName);
}
