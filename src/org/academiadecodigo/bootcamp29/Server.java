package org.academiadecodigo.bootcamp29;

import java.io.IOException;
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
            ServerSocket serverSocket = new ServerSocket();

            Socket clientSocket = serverSocket.accept();

            



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
