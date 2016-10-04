package com.niit.cdstack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Products implements Serializable {

	private static final long serialVersionUID = -922758901914038356L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;

	@NotNull
	@Min(value=10)
	private int qty;

	@NotEmpty(message = "Name cannot be empty")
	private String pname;

	private String ptype;

	@NotNull
	@Min(value=100)
	private float price;

	@NotEmpty(message = "Description cannot be empty")
	@Column(name = "Description", length = 1024)
	private String content;
	
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
