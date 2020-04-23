package com.naughtyzombie.aws;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Table - User
@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id", nullable=false, updatable = false)
	private Long id;
	private String username; public String getUsername() {return username;} public void setUsername(String input) {username=input;}
	private String password; public String getPassword() {return password;} public void setPassword(String input) {password=input;}
	private String phone; public String getPhone() {return phone;} public void setPhone(String input) {phone=input;}

	protected Register() {

	}

	
	

}
