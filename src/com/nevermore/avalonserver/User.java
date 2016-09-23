package com.nevermore.avalonserver;

public class User {
	
	private int id;
	private String username;
	private byte role;
	private Game game;
	
	public static byte NORMAL_BLUE 	= 0;
	public static byte NORMAL_RED 	= 1;
	public static byte MERLIN 		= 2;
	public static byte MORGANA 		= 3;
	public static byte ASSASIN 		= 4;
	public static byte PERCIVAL 	= 5;
	public static byte OBERON 		= 6;
	public static byte MORDRED 		= 7;
	
	public User(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public void joinGame(Game game) {
		this.game = game;
		game.addUser(this);
	}
	
	public void leaveGame() {
		this.game = null;
	}
	
	public void gameEvent(String event) {
		game.event(event.split("" + Connection.GAME_DELIMETER));
	}
	
	public boolean inGame() {
		return game != null;
	}
	
	public int getID() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean isMerlin() {
		return role == MERLIN;
	}
	
	public boolean isMorgana() {
		return role == MORGANA;
	}
	
	public boolean isAssasin() {
		return role == ASSASIN;
	}
	
	public boolean isPercival() {
		return role == PERCIVAL;
	}
	
	public boolean isOberon() {
		return role == OBERON;
	}
	
	public boolean isMordred() {
		return role == MORDRED;
	}
	
	public boolean isBlue() {
		return role == NORMAL_BLUE
			|| isMerlin()
			|| isPercival();
	}
	
	public boolean isRed() {
		return role == NORMAL_RED
			|| isMorgana()
			|| isOberon()
			|| isMordred()
			|| isAssasin();
	}
	
	public boolean isHost() {
		return game.isHost(this);
	}
	
}
