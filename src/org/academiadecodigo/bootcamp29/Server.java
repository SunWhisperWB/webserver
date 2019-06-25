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

        this.processRequest(request, clientSocket);

    }

    private void processRequest(String request, Socket clientSocket) throws IOException {

        String userRequest;

        userRequest = request.split(" ")[1];

        switch (userRequest){

            case "/":

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                File myFile = new File("www/index.html");

                out.println("HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "Content-Length" + myFile.length() + "\r\n");

                FileInputStream inputStream = null;
                DataOutputStream outputStream = null;

                inputStream = new FileInputStream("www/index.html");

                outputStream = new DataOutputStream(clientSocket.getOutputStream());


                this.sendFile(inputStream, outputStream);

                out.close();

                break;

            case "/megamanzero.jpg":

                out = new PrintWriter(clientSocket.getOutputStream(), true);

                myFile = new File("www/megamanzero.jpg");

                out.println("HTTP/1.1 200 OK\r\n"
                        + "Content-Type: image/jpg; charset=UTF-8\r\n"
                        + "Content-Length:" + myFile.length() + "\r\n");

                inputStream = new FileInputStream("www/megamanzero.jpg");

                outputStream = new DataOutputStream(clientSocket.getOutputStream());


                this.sendFile(inputStream, outputStream);

                out.close();

                break;

                default:
                    out = new PrintWriter(clientSocket.getOutputStream(), true);

                    out.println("HTTP/1.1 404 Not Found\r\n"
                            + "Content-Type: image/jpg; charset=UTF-8\r\n"
                            + "Content-Length:0\r\n");

                    out.close();

                break;
        }
    }

    private void sendFile(FileInputStream inputStream, DataOutputStream outputStream) throws IOException {

        byte[] buffer = new byte[1024];


        while (inputStream.read(buffer) != -1) {

                outputStream.write(buffer);

        }

        outputStream.close();
        inputStream.close();
    }

}
