package in.codehut.userservice.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRequestEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2095228360057032777L;
	@Column(nullable=false ,length=10)
	private String firstName;
	@Column(nullable=false ,length=10)
	private String lastName;
	@Column(nullable=false ,length=10)
	private String password;
	@Column(nullable=false ,length=10,unique=true)
	private String email;
	@Id
	@GeneratedValue
	private String userId;
	@Column(nullable=false)
	private String encryptedPassword;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
}
