package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.my.config.PropConfig;
import com.my.dao.user.MySqlUserDao;
import com.my.dao.user.UserDao;

public class MySqlDaoFactory extends DaoFactory {

	public static final Properties MySqlProps = PropConfig.getProperty("mysql.config");

	public static Connection createConnection() {
		Connection connection = null;
		
		try {
			Class.forName(MySqlProps.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try { 
			connection = DriverManager.getConnection(MySqlProps.getProperty("url"), MySqlProps.getProperty("user"), MySqlProps.getProperty("password"));
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	public UserDao getUserDao() {
		return new MySqlUserDao();
	}

}