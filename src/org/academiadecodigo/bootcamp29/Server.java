package org.academiadecodigo.bootcamp29;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        Server server = new Server();

        server.start();

    }

    private void start() {

        int portNumber = 5005;
        ExecutorService fixedPool = Executors.newFixedThreadPool(50);

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                fixedPool.submit(new ThreadHandler(clientSocket));
                System.out.println(Thread.activeCount());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fixedPool.shutdown();
    }

}