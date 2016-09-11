package com.nevermore.avalonserver;

public class DatabaseController {
	
	public static void init() {
		// TODO
	}
	
	public static boolean login(String username) {
		UsersController.addUser(username);
		return true;
	}
	
}
