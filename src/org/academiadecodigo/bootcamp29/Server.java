package org.academiadecodigo.bootcamp29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            while(true) {
                Socket clientSocket = serverSocket.accept();

                this.listen(clientSocket);


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void listen(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String request=in.readLine();

        System.out.println(request);

        this.processRequest(request);

    }

    private void processRequest(String request) {

        String[] splitRequest = request.split(" ");

        for (String component : splitRequest){
            if (component.contains("/")){
                
            }


        }

    }

}
