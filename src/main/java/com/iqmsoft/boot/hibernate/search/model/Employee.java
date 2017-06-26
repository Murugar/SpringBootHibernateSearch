package com.iqmsoft.boot.hibernate.search.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Entity(name="employees")
@Indexed
public class Employee {
	@Id
	@Column(name="emp_no")
	private int employee_id;
	
	@Field(index = Index.YES, analyze=Analyze.NO, store = Store.YES)
	@DateBridge(resolution = Resolution.DAY)
	@Column(name="birth_date")
	private Date birthdate;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="first_name")
	private String firstname;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="gender",columnDefinition = "ENUM('M', 'F', 'UNKNOWN') DEFAULT 'UNKNOWN'")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Field(index = Index.YES, analyze=Analyze.NO, store = Store.YES)
	@DateBridge(resolution = Resolution.DAY)
	@Column(name="hire_date")
	private Date hireDate;

	@OneToMany(mappedBy="employee")
	List<Title> titles; 
	
	@OneToMany(mappedBy="employee")
	List<Department_Employee> employee_department;

	
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
}
