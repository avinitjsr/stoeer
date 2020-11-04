package com.de.stroeer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name= "Users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name= "first_name")
	@NotNull(message = "firstName is mandatory")
	private String firstName;
	
	@Column(name= "last_name")
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	
	@Id
	@Column(name= "iban", unique = true)
	@NotNull(message = "iban is mandatory")
	private Long iban;

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

	public Long getIban() {
		return iban;
	}

	public void setIban(Long iban) {
		this.iban = iban;
	}

	
	
	

}
