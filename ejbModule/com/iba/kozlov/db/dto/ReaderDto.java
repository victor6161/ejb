package com.iba.kozlov.db.dto;



import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ReaderDto {




	@Override
	public String toString() {
		return "ReaderDto [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password="
				+ password + ", role=" + role + ", email=" + email + "]";
	}

	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String surname;
	@Setter
	@Getter
	private String login;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	private String role;
	@Setter
	@Getter
	private String email;
	@Setter
	@Getter
	private Date dateRegistration;

	public ReaderDto(String username) {
		super();
		this.surname = username;
	}

	public ReaderDto() {

	}

	public ReaderDto(int id, String readerName, String readerSurname) {
		this.id = id;
		this.name = readerName;
		this.surname = readerSurname;
	}

	public ReaderDto(int id, String readerName, String readerSurname, String login, String password, String role,Date date) {
		this.id = id;
		this.name = readerName;
		this.surname = readerSurname;
		this.login = login;
		this.password = password;
		this.role = role;
		this.dateRegistration = date;
	}

}
