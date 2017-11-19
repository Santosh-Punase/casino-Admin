package com.nagarro.casino.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	public Customer() {
		super();
	}

	public Customer(int id) {
		super();
		this.id = id;		
	}

	@Column
	private Date dob;
	
	@Column
	private Long contact;
	
	@Column
	private String email;
	
	@Column
	private double total_bal;
	
	@Column
	private int blocked_amt;
	
	@Column
	private String uniqId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTotal_bal() {
		return total_bal;
	}

	public void setTotal_bal(double total_bal) {
		this.total_bal = total_bal;
	}

	public int getBlocked_amt() {
		return blocked_amt;
	}

	public void setBlocked_amt(int blocked_amt) {
		this.blocked_amt = blocked_amt;
	}


	public String getUniq_id() {
		return uniqId;
	}

	public void setUniq_id(String uniq_id) {
		this.uniqId = uniq_id;
	}
}

