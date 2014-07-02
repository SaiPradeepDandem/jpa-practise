package com.sai.jpa.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locality {
	@Id
	@GeneratedValue
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Long id;

	private String name;

	private String state;

	public Locality() {
		super();
	}

	public Locality(String name, String state) {
		super();
		this.name = name;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
