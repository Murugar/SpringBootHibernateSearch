package com.iqmsoft.boot.hibernate.search.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity(name="salaries")
public class Salary implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="emp_no")
	private Employee employee;
	
	@Column(name="salary")
	private int salery;
	
	@Id
	@Column(name="from_date")
	private Date fromDate;

	@Column(name="to_date")
	private Date toDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getSalery() {
		return salery;
	}

	public void setSalery(int salery) {
		this.salery = salery;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Salary))
			return false;

		Salary other = (Salary) o;
		if (!(this.equals(other)))
			return false;

		return true;
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getEmployee().getEmployee_id()).append(this.getSalery()).toHashCode();
    }
	
	

}
