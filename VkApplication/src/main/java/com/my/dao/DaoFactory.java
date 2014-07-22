package com.my.dao;

import com.my.dao.user.UserDao;

public abstract class DaoFactory {

	public static final int H2 = 1;
	public static final int MySQL = 2;

	public abstract UserDao getUserDao();

	public static DaoFactory getDaoFactory(int factoryNum) {

		switch (factoryNum) {
		case H2:
			return new H2DaoFactory();
		case MySQL:
			return new MySqlDaoFactory();
		default:
			return null;
		}
	}
}