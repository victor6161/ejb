package com.iba.kozlov.db.dao;

public class ReaderQueryFacade {
	
	public static String getQueryReadReader(){
		return "SELECT re.id,re.name,re.surname,re.login,re.password,ro.role,re.date_registration FROM reader As re LEFT JOIN role As ro ON re.role_id = ro.id ";
	}

	public static String getQueryCreate() {
		return "insert into reader (login,password,name,surname,role_id,email,date_registration) values (?,?,?,?,?,?,NOW())";
	}

}
