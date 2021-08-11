package in.codehut.userservice.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationBeans {
	@Bean("bCrypt")
	public BCryptPasswordEncoder getBCrypt() {
		return new BCryptPasswordEncoder();
	}
}
