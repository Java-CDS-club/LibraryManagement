package com.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Issued implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "callno")
	private String callno;

	@Column(name = "s_id")
	private String studentid;

	public Issued() {
		super();
	}

	public Issued(String callno, String s_id) {
		super();
		this.callno = callno;
		this.studentid = s_id;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	@Override
	public int hashCode() {
		int result = studentid.hashCode() + callno.hashCode();
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
		Issued other = (Issued) obj;
		if (callno == null) {
			if (other.callno != null)
				return false;
		} else if (!callno.equals(other.callno))
			return false;
		if (studentid != other.studentid)
			return false;
		return true;
	}

}