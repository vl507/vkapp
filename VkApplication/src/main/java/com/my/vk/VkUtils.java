package com.my.vk;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VkUtils {
	
	public static Users getUsers(VkExecutor vkExe) {
		Users users;
		try {
			String jsonObj = vkExe.executeVkMethod(VkConstants.USERS_GET, new String("bdate,country,city"), "5.23");
			ObjectMapper mapper = new ObjectMapper();
	    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    	try {
				users = mapper.readValue(jsonObj, Users.class);
				return users;
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
