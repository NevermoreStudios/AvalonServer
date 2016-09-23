package com.nevermore.avalonserver;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private int id;
	private User host;
	private List<User> users = new ArrayList<User>();
	private String name;
	private boolean started;
	
	public Game(int id, User host, String name) {
		this.id = id;
		this.host = host;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addUser(User user) {
		if(users.size() < 10) {
			users.add(user);
		} else {
			// TODO: Error handling
		}
		
	}
	
	public String stringify() {
		String res = "";
		res += Connection.GAME_DELIMETER + id + Connection.GAME_DELIMETER;
		for(User user : users) {
			res += user.getUsername() + Connection.GAME_DELIMETER;
		}
		return res;
	}
	
	public void event(String[] args) {
		
	}
	
	public boolean isHost(User user) {
		return user.getID() == host.getID();
	}
	
	public boolean hasStarted() {
		return started;
	}
	
	public void start() {
		started = true;
	}
	
	public void end() {
		for(User user : users) {
			user.leaveGame();
		}
	}
	
}