package com.maranatha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */
@Entity
@Table(name="usuario")
public class User {
	@Id
	@Column(name="id")
	@GenericGenerator(strategy = "increment", name = "myid")

	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="lastname")
	private String lastName;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="type")
	private String type;
	@Column(name="age")
	private Integer age;
	@Column(name="location_id")
	private Integer locationId;
	
	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public User(Integer id){
		this.id = id;
	}
			
	public User(Integer id, String name, String lastName, String username, String password, String type, Integer age){
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.age = age;
	}

	public User(String name, String lastName, String username, String password, String type, Integer age, Integer locationId){
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.age = age;
		this.locationId =locationId;
	}
	
	public User(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


}
