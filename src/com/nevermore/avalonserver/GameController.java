package com.nevermore.avalonserver;

import java.util.HashMap;
import java.util.Map;

public class GameController {
	
	private static Map<Integer, Game> games = new HashMap<Integer, Game>();
	private static int lastGameIndex = 1;
	
	public static void init() {
		// TODO
	}
	
	public static String stringify() {
		String res = "";
		for(int i : games.keySet()) {
			res += Connection.ROOM_DELIMETER + games.get(i).stringify();
		}
		return res;
	}
	
	public static void startGame(User host, String name) {
		int id = lastGameIndex++;
		Game game = new Game(id, host, name);
		games.put(id, game);
		host.joinGame(game);
	}
	
	public static void endGame(int id) {
		games.get(id).end();
		games.remove(id);
	}
	
	public static Game getGame(int id) {
		return games.get(id);
	}
	
}
