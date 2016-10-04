package com.niit.cdstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int u_id;

	@NotEmpty(message = "Name Cannot be Empty")
	@Pattern(regexp="^[A-Za-z]*$",message="Enter only Letters")
	private String name;
	@NotEmpty(message = "Username Cannot be Empty")
	private String username;
	@Size(min=6,max=10,message="Password should 6-10 charcters long")
	private String password;
	@NotEmpty(message = "Email Cannot be Empty")
	@Pattern(regexp="^(.+)@(.+)$",message="Enter a valid Email id")
	private String email;
	private boolean enabled = true;

	@Transient
	@NotEmpty(message = "This Field sholud be filled")
	private String cpass;

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isEnabled() {
		return enabled;
	}

}
