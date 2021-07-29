package in.codehut.userservice.models;

import java.util.Date;

public class User {
	private String userId;
	private String userName;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userDOB=" + userDOB + "]";
	}
	public User(String userId, String userName, Date userDOB) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDOB = userDOB;
	}
	public User() {
		super();
	}
	
}
