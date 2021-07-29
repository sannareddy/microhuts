package in.codehut.userservice.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codehut.userservice.data.models.UserEntity;
import in.codehut.userservice.data.repos.UserRepository;
import in.codehut.userservice.models.User;
import in.codehut.userservice.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		userRepository.save(userEntity);
		return user;
	}

}