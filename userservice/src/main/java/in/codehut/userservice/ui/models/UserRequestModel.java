package in.codehut.userservice.ui.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel {
	@NotNull(message="username shoould not be null")
	@Size(min=4, max=16 ,message="name should be minium 4 characters and max 16 characters")
	private String firstName;
	@NotNull(message="username shoould not be null")
	@Size(min=4, max=16 ,message="name should be minium 4 characters and max 16 characters")
	private String lastName;
	@NotNull(message="username shoould not be null")
	@Size(min=4, max=16 ,message="name should be minium 4 characters and max 16 characters")
	private String password;
	@NotNull
	@Email
	private String email;
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

}
