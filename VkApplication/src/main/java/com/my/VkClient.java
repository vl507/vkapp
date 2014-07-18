package com.my;

import com.my.vk.VkExecutor;
import com.my.vk.VkUtils;

public class VkClient {
	public static void main(String[] args) {
		VkExecutor vkExe = new VkExecutor(new ProxyConfig(new ProxyInstance()));
//		without proxy:
//		VkExecutor vkExe = new VkExecutor();
		System.out.println(VkUtils.getUsers(vkExe));
	}
}