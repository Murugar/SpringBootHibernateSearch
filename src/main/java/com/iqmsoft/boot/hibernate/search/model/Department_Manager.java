package com.iqmsoft.boot.hibernate.search.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="dept_manager", 
indexes = {
        @Index(columnList = "dept_no", name = "dept_no")})
public class Department_Manager implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_no")
	private Employee employee;

	@Id
	@ManyToOne
	@JoinColumn(name = "dept_no")
	private Department department;
	
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Department_Manager))
			return false;

		Department_Manager other = (Department_Manager) o;
		if (!(this.equals(other)))
			return false;

		return true;
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getEmployee().getEmployee_id()).append(this.getDepartment().getDepartmentId()).toHashCode();
    }
	

	
	
	
	

}
