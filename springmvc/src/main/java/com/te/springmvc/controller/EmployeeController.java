package com.te.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDao;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService dao;

	@GetMapping("/emplogin")
	public String getLogin() {

		return "loginForm";

	}

	@PostMapping("/emplogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		EmployeeBean bean = dao.authenticate(id, password);
		if (bean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", bean);
			return "homepage";
		} else {
			map.addAttribute("errmsg", "Invalid Credentials");
			return "loginForm";
		}

	}

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {
			map.addAttribute("errMsg", "please login first");
			return "emplogin";
		}
	}//end of getSearchForm

	@GetMapping("/search")
	public String searchEmp(int id, ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			EmployeeBean bean2 = (EmployeeBean) dao.getEmployee(id);
			if (bean2 != null) {
				map.addAttribute("data", bean2);

			} else {
				map.addAttribute("msg", "Data not found for id:" + id);
			}
			return "searchForm";
		} else {
			map.addAttribute("errMsg", "please login first");
			return "emplogin";
		}
	}//end of searchEmp

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Logout Succesfull");
		return "loginForm";
	}//end of logout
	
	@GetMapping("/getdelete")
	public String getDeleteForm(ModelMap map,@SessionAttribute(name = "emp",required = false)EmployeeBean employeeBean) {
		if(employeeBean!=null) {
			return "deleteForm";
		}else {
			map.addAttribute("errMsg", "please login first");
			return null;
			
		}
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(int id,@SessionAttribute(name = "emp",required = false)EmployeeBean bean,ModelMap map) {
		if(bean!=null) {
			boolean deleted = dao.deleteEmp(id);
			if(deleted==true) {
				map.addAttribute("msg", "deleted successfully");
				return "deleteForm";
			}
			else {
				map.addAttribute("errmsg", "user not found");
				return "deleteForm";
			}
			
		}
		
		return null;
		
	}
	
	@GetMapping("/viewall")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = dao.getAlldata();
			map.addAttribute("empdata", employeeBeans);
			return "alldata";
		} else {
			map.addAttribute("msg", "no employees found");
			return "alldata";
		}

	}

}// end of controller
