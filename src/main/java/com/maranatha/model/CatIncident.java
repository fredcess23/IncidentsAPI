package com.maranatha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cat_incident")
public class CatIncident {
	
	@Id
	@Column(name="id")
	@GenericGenerator(strategy = "increment", name = "myid")
	private Integer id;
	
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="nombre")
	private String nombre;
	
	public CatIncident(){}
	
	public CatIncident(Integer id, String name, String description, String nombre) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.nombre = nombre;
	}
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
