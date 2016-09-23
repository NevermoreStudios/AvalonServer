package com.nevermore.avalonserver;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
        DatabaseController.init();
        UsersController.init();
        SocketController.init();
    }

}