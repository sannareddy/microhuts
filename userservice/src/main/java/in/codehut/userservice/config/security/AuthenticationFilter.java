package in.codehut.userservice.config.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.codehut.userservice.models.UserModel;
import in.codehut.userservice.service.UserService;
import in.codehut.userservice.ui.models.LoginIO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	Logger logger = LogManager.getLogger(AuthenticationFilter.class);
	
	private UserService userService;
	private Environment env;
	
	public AuthenticationFilter(UserService userService, Environment env, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.env = env;
		super.setAuthenticationManager(authenticationManager);
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		LoginIO loginIO = null;
		try {
			loginIO = new ObjectMapper().readValue(request.getInputStream(), LoginIO.class);
			return getAuthenticationManager()
					.authenticate(new UsernamePasswordAuthenticationToken(
											loginIO.getEmail(), 
											loginIO.getPassword(),
											new ArrayList<>()));
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String email = ((User)auth.getPrincipal()).getUsername();
		UserModel userModel = userService.getUserByEmail(email);
		
		String jwtToken = Jwts.builder()
							.setSubject(userModel.getUserId())
							.setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(env.getProperty("token.exp_time"))))
							.signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
							.compact();
		response.addHeader("token", jwtToken);
		response.addHeader("userId",userModel.getUserId());
	}
	

}
