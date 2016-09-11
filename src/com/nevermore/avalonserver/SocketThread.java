package com.nevermore.avalonserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
	
	boolean running = true;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	User user;
	
	public static final char GAME_DELIMETER = 65535;
	public static final char CHAT_DELIMETER = 65534;
	
	
	public SocketThread(Socket socket) {
		try {
			this.socket = socket;
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch(IOException e) {
			e.printStackTrace();
			// TODO: Error handling
		}
		
	}
	
	public void run() {
		while(running) {
			try {
				String line = in.readLine(),
					   message = line.substring(1);
				switch(line.charAt(0)) {
					case GAME_DELIMETER:
						if(user == null) {
							if(DatabaseController.login(message)) {
								
							}
						}
						break;
					case CHAT_DELIMETER:
						if(user == null) {
							System.out.println("Klijent je retard");
							// TODO: Error handling
						} else {
							SocketController.broadcastChat(user, message);
						}
						break;
					default:
						System.out.println("Wtf lazo kako si napravio da mi klijent salje ovo djubre");
						// TODO: Error handling
						break;
				}
			} catch(IOException e) {
				e.printStackTrace();
				// TODO: Error handling
			}
			
		}
	}
	
	public void sendChatMessage(User user, String message) {
		if(out == null) {
			System.out.println("Output undefined");
			// TODO: Error handling
		} else {
			out.println(CHAT_DELIMETER + user.getID() + CHAT_DELIMETER + message);
		}
	}
	
	// TODO: Close socket
	
}