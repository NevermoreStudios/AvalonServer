package com.nevermore.avalonserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketController {
	
	private static List<SocketThread> sockets = new ArrayList<SocketThread>();
	public static ServerSocket server;
	private static boolean running = true;
	
	public static void init() {
		try {
			server = new ServerSocket(9090, 0, InetAddress.getLoopbackAddress());
		} catch(IOException e) {
			// TODO: Error handling
		}
		while(running) {
			update();
		}
	}
	
	private static void update() {
		try {
			Socket socket = server.accept();
			if(socket != null) {
				sockets.add(new SocketThread(socket));
			}
        } catch(IOException e) {
        	// TODO: Error handling
        }
	}
	
	public static void stop() {
		running = false;
	}
	
	public static void broadcastChat(User user, String message) {
		for(SocketThread socket : sockets) {
			socket.sendChatMessage(user, message);
		}
	}
	
}