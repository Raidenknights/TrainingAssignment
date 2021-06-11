package com.example.MyWeb.UserService.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserModel,Integer> {
	public UserModel findByEmail(String email);
}
