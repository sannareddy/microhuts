package in.codehut.userservice.ui.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserPaymentsIO {
	private int id;
	private String userId;
	private String userName;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date userDOB;
	private List<PaymentsIO> paymentsIO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public List<PaymentsIO> getPaymentsIO() {
		return paymentsIO;
	}
	public void setPaymentsIO(List<PaymentsIO> paymentsIO) {
		this.paymentsIO = paymentsIO;
	}
	public UserPaymentsIO(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
}
