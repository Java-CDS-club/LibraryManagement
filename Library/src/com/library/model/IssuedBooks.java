package com.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IssuedBooks")
public class IssuedBooks implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	Issued Issue;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date doi;

	public IssuedBooks() {
		super();
	}

	public IssuedBooks(Issued Issue, Date d) {
		super();
		this.Issue = Issue;
		this.doi = d;
	}

	public Issued getIssue() {
		return Issue;
	}

	public void setIssue(Issued issue) {
		Issue = issue;
	}

	public Date getDoi() {
		return doi;
	}

	public void setDoi(Date doi) {
		this.doi = doi;
	}

}