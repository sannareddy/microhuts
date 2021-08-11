package in.codehut.userservice.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.codehut.userservice.data.models.UserEntity;
import in.codehut.userservice.data.repos.UserRepository;
import in.codehut.userservice.models.UserModel;
import in.codehut.userservice.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCrypt;
	@Autowired
	public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCrypt) {
		super();
		this.userRepository = userRepository;
		this.bCrypt = bCrypt;
	}


	@Override
	public UserModel createUser(UserModel user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setEncryptedPassword(bCrypt.encode(user.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		userRepository.save(userEntity);
		return user;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findByEmail(username);
		if(entity == null) new UsernameNotFoundException("Username Not Found");
		return new User(username, entity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}


	@Override
	public UserModel getUserByEmail(String email) {
		UserEntity entity = userRepository.findByEmail(email);
		if(entity == null) new UsernameNotFoundException("Username Not Found");
		ModelMapper modelMapper = new ModelMapper();
		UserModel userModel= modelMapper.map(entity, UserModel.class);
		return userModel;
	}

}
