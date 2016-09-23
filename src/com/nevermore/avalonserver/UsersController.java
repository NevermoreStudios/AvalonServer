package com.nevermore.avalonserver;

import java.util.HashMap;
import java.util.Map;

public class UsersController {
	
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static int lastUserIndex = 0;
	
	public static void init() {
		// TODO
	}
	
	public static User getUserByID(int id) {
		return users.get(id);
	}
	
	public static User addUser(String username) {
		int id = lastUserIndex++;
		User user = new User(id, username);
		users.put(id, user);
		return user;
	}
	
}
