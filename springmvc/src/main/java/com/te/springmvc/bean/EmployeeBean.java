package com.te.springmvc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "enmployee_info")
public class EmployeeBean implements Serializable {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private Date dob;

}
