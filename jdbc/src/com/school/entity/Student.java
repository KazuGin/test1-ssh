package com.school.entity;

import java.util.Date;

public class Student {

	private Integer id;
	private String studentName;
	private String sex;
	private String phone;
	private Integer gradeId;
	private Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Student(Integer id, String studentName, String sex, String phone,
			Integer gradeId, Date birthday) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.sex = sex;
		this.phone = phone;
		this.gradeId = gradeId;
		this.birthday = birthday;
	}
	public Student() {
		super();
	}
	public Student(String studentName, String sex, String phone,
			Integer gradeId, Date birthday) {
		super();
		this.studentName = studentName;
		this.sex = sex;
		this.phone = phone;
		this.gradeId = gradeId;
		this.birthday = birthday;
	}
	
	
}
