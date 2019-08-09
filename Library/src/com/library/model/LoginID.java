package com.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoginID implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "User")
	private String user;
	@Column(name = "password")
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginID() {
		super();
	}

	public LoginID(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	@Override
	public int hashCode() {
		int result = password.hashCode() + user.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginID other = (LoginID) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user != other.user)
			return false;
		return true;
	}
}