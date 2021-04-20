package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDao;
import com.te.springmvc.dao.EmployeeDaoImpl;
@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	private EmployeeDao dao;
	
	@Override
	public EmployeeBean authenticate(int id, String password) {
		
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeBean> getAlldata() {
		// TODO Auto-generated method stub
		return dao.getAlldata();
	}

}
