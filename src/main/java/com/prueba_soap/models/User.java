package com.prueba_soap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users_soapAPI")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Añade el ID automaticamente por conveniencia de Hibernate
	@Column(name = "user_id")
	private Long userId;
	
	@Column
	private String name;	
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	//Getters and setters del modelo Users
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}