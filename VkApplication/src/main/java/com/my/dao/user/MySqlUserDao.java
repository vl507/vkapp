package com.my.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.my.dao.MySqlDaoFactory;

public class MySqlUserDao implements UserDao {
	
	public MySqlUserDao() {
		
	}
	
	@Override
	public void insert(List<UserBean> userBean) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String insertSql = "INSERT INTO users"
				+ "(user_id, first_name, last_name, bdate, city, country) " + "VALUES"
				+ "(?,?,?,?,?,?)";
		
		try {
			connection = MySqlDaoFactory.createConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(insertSql);
			for (UserBean ub : userBean) {
				statement.setInt(1, ub.getUserId());
				statement.setString(2, ub.getFirstName());
				statement.setString(3, ub.getLastName());
				statement.setString(4, ub.getBdate());
				statement.setString(5, ub.getCity());
				statement.setString(6, ub.getCountry());
				statement.addBatch();
			}
			statement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
