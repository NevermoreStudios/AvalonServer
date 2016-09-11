package com.nevermore.avalonserver;

public class User {
	
	private int id;
	private String username;
	private byte role;
	
	public static byte NORMAL_BLUE = 0;
	public static byte NORMAL_RED = 1;
	public static byte MERLIN = 2;
	public static byte MORGANA = 3;
	public static byte ASSASIN = 4;
	public static byte PERCIVAL = 5;
	public static byte OBERON = 6;
	public static byte MORDRED = 7;
	
	public User(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
