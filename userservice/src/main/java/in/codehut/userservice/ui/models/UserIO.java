package in.codehut.userservice.ui.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserIO {
	private String userId;
	private String userName;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date userDOB;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public UserIO() {
		super();
	}
	
}
