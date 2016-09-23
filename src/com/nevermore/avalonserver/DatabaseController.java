package com.nevermore.avalonserver;

public class DatabaseController {
	
	public static void init() {
		// TODO
	}
	
	public static User login(String username) {
		// TODO: Implement better
		return UsersController.addUser(username);
	}
	
}
