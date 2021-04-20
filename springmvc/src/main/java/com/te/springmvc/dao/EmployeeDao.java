package com.te.springmvc.dao;

import java.util.List;

import com.te.springmvc.bean.EmployeeBean;

public interface EmployeeDao {
	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmp(int id);

	public List<EmployeeBean> getAlldata();
}
