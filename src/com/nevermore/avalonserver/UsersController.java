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
	
	public static void addUser(String username) {
		int id = lastUserIndex++;
		users.put(id, new User(id, username));
	}
	
}
