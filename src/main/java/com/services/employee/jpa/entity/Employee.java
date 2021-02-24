package com.services.employee.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employee")
public class Employee{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "airst_name")
    private String airst_name;

    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "email")
    private String email;
	
    @Column(name = "phone")
    private String phone;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirst_name() {
		return airst_name;
	}

	public void setAirst_name(String airst_name) {
		this.airst_name = airst_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Employee() {
		
	}

	public Employee(long id, String airst_name, String last_name, String email, String phone) {
		this.id = id;
		this.airst_name = airst_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", airst_name=" + airst_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
    
}
