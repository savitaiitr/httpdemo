package com.rsystem.Day1.Employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Employee Information",value="Employee Information")
@Entity
@NamedQuery(name="GET_EMPLOYEES_QUERY", query="Select E from Employee E")
public class Employee

{

	@Max(value = 100, message = "Employee Id should not be greater than 100")
	@ApiModelProperty(notes="Employee Id should not be greater than 100")
	
	@Id
	private int empid;

	
	@NotNull(message = "name should not be null")
	private String name;

	private Date birthDate;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Employee(int empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	

	public Employee(int empid, String name, Date birthDate) {
		super();
		this.empid = empid;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	

}
