package in.codehut.userservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.codehut.userservice.models.UserModel;

public interface UserService extends UserDetailsService{
	UserModel createUser(UserModel user);
	UserModel getUserByEmail(String email);
}
