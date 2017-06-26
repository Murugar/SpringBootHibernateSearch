package com.iqmsoft.boot.hibernate.search.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "departments")
public class Department {
	@Id
	@Column(name="dept_no", length=4,columnDefinition="CHAR(4)")
	private String departmentId;

	@Column(name="dept_name", length=40)
	private String departmentName;
	
	@OneToMany(mappedBy="department")
	List<Department_Employee> employee_department;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Department_Employee> getEmployee_department() {
		return employee_department;
	}

	public void setEmployee_department(List<Department_Employee> employee_department) {
		this.employee_department = employee_department;
	}
	
	
	

}
