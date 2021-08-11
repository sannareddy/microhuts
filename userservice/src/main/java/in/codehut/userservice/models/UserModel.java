package in.codehut.userservice.models;

import java.util.Date;

public class UserModel {
	private String userId;
	private String userName;
	private Date userDOB;
	private String password;
	private String email;
	private String encryptedPassword;
	
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
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userDOB=" + userDOB + "]";
	}
	public UserModel(String userId, String userName, Date userDOB) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDOB = userDOB;
	}
	public UserModel() {
		super();
	}
	
}
