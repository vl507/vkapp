package com.my;

import java.util.List;

import com.my.dao.DaoFactory;
import com.my.dao.user.H2UserDao;
import com.my.dao.user.UserBean;
import com.my.dao.user.UserDao;
import com.my.proxy.ProxyConfig;
import com.my.proxy.ProxyInstance;
import com.my.transmute.Transmutor;
import com.my.vk.Users;
import com.my.vk.VkExecutor;
import com.my.vk.VkUtils;

public class VkClient {
	public static void main(String[] args) {
		VkExecutor vkExe = new VkExecutor(new ProxyConfig(new ProxyInstance()));
//		without proxy:
//		VkExecutor vkExe = new VkExecutor();
		Users users = VkUtils.getUsers(vkExe);
		System.out.println(users);
		
		List<UserBean> userBeanList = Transmutor.convertVkUsersToDao(users);
		
		UserDao ud = DaoFactory.getDaoFactory(DaoFactory.MySQL).getUserDao();
		ud.insert(userBeanList);
	}

}