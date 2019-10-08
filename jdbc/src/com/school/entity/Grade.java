package com.school.entity;

public class Grade {

	private Integer id;
	private String gradeName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Grade(Integer id, String gradeName) {
		super();
		this.id = id;
		this.gradeName = gradeName;
	}
	public Grade(String gradeName) {
		super();
		this.gradeName = gradeName;
	}
	public Grade() {
		super();
	}
	
	
}
