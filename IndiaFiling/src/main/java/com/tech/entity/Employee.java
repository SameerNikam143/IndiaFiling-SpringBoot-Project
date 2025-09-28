package com.tech.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class Employee {

	@Id
	private Integer id;

	@NotBlank(message = "FirstName Must Not Be Blank")
	private String firstName;

	@NotEmpty(message = "MiddleName Must Not Be Empty")
	private String middleName;

	@NotNull(message = "LastName Must Not Be Null")
	private String lastName;

	@NotNull(message = "Rank must not be null")
	@Positive(message = "Rank Must Be Possitive")
	private Long rank;
    
	@Min(value = 1,message = "Age Must Be Above 1")
	@Max(value = 100,message = "Age Must Be Below 100")
	private int age;

	@NotNull(message = "Gender Must Not Be Null")
	private String gender;

	@NotBlank(message = "DepartMent Must Not Be Blank")
	private String department;

	@Email(message = "Email Must Be Valid")
    @NotBlank(message = "Email must not be blank")
    private String email;

	@NotNull(message = "Mobile number must not be null")
	@Min(value = 1000000000L, message = "Mobile number must be 10 digits")
	@Max(value = 9999999999L, message = "Mobile number must be 10 digits")
	private Long mobileNum;

	@Embedded
	@Valid
	private Address addrs;

	@NotBlank(message = "UserName Must Not Be Blank")
	private String username;

	@NotBlank(message = "Password Must Not Be Blank")
	private String password;

	@Transient
	private String confirmPass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public Address getAddrs() {
		return addrs;
	}

	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

}
