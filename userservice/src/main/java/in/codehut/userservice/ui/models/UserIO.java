package in.codehut.userservice.ui.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserIO {
	private String userID;
	private String userName;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date userDOB;
	private String password;
	private String email;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserIO() {
		super();
	}
	public UserIO(String userName, Date userDOB, String password, String email) {
		super();
		this.userName = userName;
		this.userDOB = userDOB;
		this.password = password;
		this.email = email;
	}
	public UserIO(String userName, Date userDOB) {
		super();
		this.userName = userName;
		this.userDOB = userDOB;
	}
	
}
