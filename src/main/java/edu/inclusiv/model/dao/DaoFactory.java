package edu.inclusiv.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private String url;
	private String user;
	private String password;
	
	public DaoFactory(String url, String usr, String pass) {
		this.url = url;
		this.user = usr;
		this.password = pass;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			
		}
		
		DaoFactory daoFactory = new DaoFactory("jdbc:mysql://localhost:3306/my_bank", "root", null);
		
		return daoFactory;
	}
	
	public UserImpDAO getUserImpDAO() {
		return new UserImpDAO(this);
	}
	
	public AccountImpDAO getAccountImpDAO() {
		return new AccountImpDAO(this);
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
