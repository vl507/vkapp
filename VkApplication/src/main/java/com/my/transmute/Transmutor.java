package com.my.transmute;

import java.util.ArrayList;
import java.util.List;

import com.my.dao.user.UserBean;
import com.my.vk.Users;
import com.my.vk.Users.User;

public class Transmutor {
	public static List<UserBean> convertVkUsersToDao(Users users) {
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		List<User> userList = users.getUsers();
		for (User user : userList) {
			UserBean userBean = new UserBean();
			userBean.setUserId(user.getId());
			userBean.setFirstName(user.getFirstName());
			userBean.setLastName(user.getLastName());
			userBean.setBdate(user.getBdate());
			if (user.getCity() != null) {
				userBean.setCity(user.getCity().getTitle());
			}
			if (user.getCountry() != null) {
				userBean.setCountry(user.getCountry().getTitle());
			}
			userBeanList.add(userBean);
		}
		return userBeanList;
	}
}
