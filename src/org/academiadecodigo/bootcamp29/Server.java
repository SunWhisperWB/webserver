package org.academiadecodigo.bootcamp29;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        Server server = new Server();

        server.start();

    }

    private void start() {

        int portNumber = 5005;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ThreadHandler threadHandler = new ThreadHandler(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


