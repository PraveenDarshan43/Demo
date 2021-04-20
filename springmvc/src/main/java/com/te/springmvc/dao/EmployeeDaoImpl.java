package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeBean authenticate(int id, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDB");
		EntityManager manager = factory.createEntityManager();

		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("login successfull");
					return bean;
				} else {
					System.out.println("invalid credentials");
					return null;
				}
			} else {
				System.out.println("user not found");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDB");
		EntityManager manager = factory.createEntityManager();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			return bean;
		} else {

			return null;
		}
	}

	@Override
	public boolean deleteEmp(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDB");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
	     transcation.begin();
	     if (bean != null) {
	    	 manager.remove(bean);
	    	 transcation.commit();
			} else {

				return false;
			}

		return false;
	}

	@Override
	public List<EmployeeBean> getAlldata() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDB");

		EntityManager manager = factory.createEntityManager();
		
		String query = "from EmployeeBean";
		
		javax.persistence.Query query2 = manager.createQuery(query);
		
		List<EmployeeBean> list = query2.getResultList();
		if(list!=null) {
			return list;
		}
		else {
			return null;
		}
		
	
	}

}
