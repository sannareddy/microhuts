package in.codehut.userservice.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.codehut.userservice.feignclients.PaymentsClient;
import in.codehut.userservice.models.UserModel;
import in.codehut.userservice.service.UserService;
import in.codehut.userservice.ui.models.PaymentsIO;
import in.codehut.userservice.ui.models.UserIO;
import in.codehut.userservice.ui.models.UserPaymentsIO;

@RestController
@RequestMapping("/users")
public class UsersController {
	private static Logger logger = LogManager.getLogger(UsersController.class);
	@Autowired
	UserService userService;
	@Autowired
	Environment env;
	@Autowired
	PaymentsClient paymentsClient;
	@GetMapping("")
	@ResponseBody
	public List<UserIO> getUsers(){
		logger.info("Entered: "+env.getProperty("local.server.port"));
		logger.info("Entered: "+env.getProperty("programmer.name"));
		List<UserIO> users = new ArrayList<>();
		UserIO user = new UserIO("Vamsi",new Date());
		users.add(user);
		user = new UserIO("Druva",new Date());
		users.add(user);		
		return users;
	}
	
	@PostMapping
	public ResponseEntity<UserIO> createUser(@RequestBody UserIO user) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserModel userModel= modelMapper.map(user, UserModel.class);
		userModel = userService.createUser(userModel);
		user = modelMapper.map(userModel,UserIO.class);		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	@GetMapping(path="/{userid}/payments",
				produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserPaymentsIO> getUserPayments(@PathVariable("userid") int id){
		logger.info("Entered: "+env.getProperty("local.server.port"));
		logger.info("Entered: "+env.getProperty("programmer.name"));
		UserPaymentsIO userPaymentIO = new UserPaymentsIO(id, "Vamsi");
		List<PaymentsIO> payments = paymentsClient.getPayments(id);
		userPaymentIO.setPaymentsIO(payments);
		return ResponseEntity.status(HttpStatus.FOUND).body(userPaymentIO);		
	}

}
