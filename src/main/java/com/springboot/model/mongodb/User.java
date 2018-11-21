package com.springboot.model.mongodb;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */

@Document(collection = "users")
public class User {

	@Id
	public String id;

	@Field("first_name")
	@NotEmpty(message = "first_name can not be empty.")
	@Size(max = 100, message = "first_name can not be more than 100 characters.")
	private String firstName;

	@Field("last_name")
	@NotEmpty(message = "last_name can not be empty.")
	@Size(max = 100, message = "last_name can not be more than 100 characters.")
	private String lastName;

	@Field("email")
	@NotEmpty(message = "email can not be empty.")
	@Size(max = 100, message = "email can not be more than 100 characters.")
	private String email;

	@Field("phonenumber")
	@NotEmpty(message = "phonenumber can not be empty.")
	@Size(max = 12, message = "phonenumber can not be more than 12 characters.")
	private String phonenumber;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	}
