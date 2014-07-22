package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.my.config.PropConfig;
import com.my.dao.user.H2UserDao;
import com.my.dao.user.UserDao;

public class H2DaoFactory extends DaoFactory {

	public static final Properties H2Props = PropConfig.getProperty("h2.config");

	public static Connection createConnection() {
		Connection connection = null;
		
		try {
			Class.forName(H2Props.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try { 
			connection = DriverManager.getConnection(H2Props.getProperty("url"), H2Props.getProperty("user"), H2Props.getProperty("password"));
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	public UserDao getUserDao() {
		return new H2UserDao();
	}

}