package com.example.javaconfig.main.dto;

public class ExampleDTO {

	private Integer idx = null;
	private String name = null;
	private Integer age = null;
	private String country = null;

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserDTO [idx=" + idx + ", name=" + name + ", age=" + age + ", country=" + country + "]";
	}

}
