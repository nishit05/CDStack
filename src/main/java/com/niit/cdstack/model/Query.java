package com.niit.cdstack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Query implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String q_id;

	@NotEmpty(message = "Name can't be empty")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Enter only Letters")
	private String name;

	@NotEmpty(message = "Email Cannot be Empty")
	@Email(message = "Enter a valid email")
	private String email;

	@NotEmpty(message = "Number Cannot be Empty")
	@Pattern(regexp = "^[789]\\d{9}", message = "Enter 10 digit numeric mobile number starting with 7,8 or 9")
	private String mno;

	@Column(length = 850)
	@NotEmpty(message = "Query can't be empty")
	private String query;

	public String getQ_id() {
		return q_id;
	}

	public void setQ_id(String q_id) {
		this.q_id = q_id;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

}
