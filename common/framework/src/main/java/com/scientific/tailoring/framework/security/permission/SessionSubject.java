package com.scientific.tailoring.framework.security.permission;

import java.util.HashSet;
import java.util.Set;

import com.github.foxnic.springboot.mvc.RequestParameter;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.crm.Department;
import com.scientific.tailoring.domain.crm.Employee;
import com.scientific.tailoring.domain.system.User;

public class SessionSubject {
	
	
	private String token;
	private User user;
	private Company company;

	public Employee getEmployee() {
		return employee;
	}

	public Department getDepartment() {
		return department;
	}

	private Employee employee;
	private Department department;
	
	private Set<String> permisions=new HashSet<>();
	
	
	public SessionSubject(String token,User user,Company company,Department department,Employee employee) {
		this.token=token;
		this.user=user;
		this.company=company;
		this.department=department;
		this.employee=employee;
	}
	
	/**
	 * 账户信息
	 * */
	public User getUser() {
		return user;
	}
	
	/**
	 * 公司信息
	 * */
	public Company getCompany() {
		return company;
	}

	public String getToken() {
		return token;
	}

	/**
	 * 返回当前登录账户的ID
	 * */
	public Long getUserId() {
		if(this.user==null) return null;
		return this.user.getId();
	}
 
}
