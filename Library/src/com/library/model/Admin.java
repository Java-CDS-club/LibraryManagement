package com.library.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	LoginID id;
	private String a_name;

	public Admin() {
		super();
	}

	public Admin(LoginID id, String a_name) {
		super();
		this.id = id;
		this.a_name = a_name;
	}

	public LoginID getId() {
		return id;
	}

	public void setId(LoginID id) {
		this.id = id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

}
