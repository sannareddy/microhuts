package in.codehut.userservice.config.security;

import javax.servlet.Filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import in.codehut.userservice.service.UserService;
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	Logger logger = LogManager.getLogger(WebSecurity.class);
	private Environment env;
	private UserService userService;
	private BCryptPasswordEncoder bCrypt; 

	@Autowired
	public WebSecurity(Environment env,UserService userService,BCryptPasswordEncoder bCrypt){
		this.env = env;
		this.userService = userService;
		this.bCrypt = bCrypt;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info(env.getProperty("gateway.ip"));
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/**")
				.hasIpAddress("192.168.1.115")
				.and().addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}
	private Filter getAuthenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter(userService,env,authenticationManager());
		filter.setFilterProcessesUrl(env.getProperty("login.url"));
		return filter;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCrypt);
	}
	

}
