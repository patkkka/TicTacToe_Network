package com.javaAcademy.OXGame.network;

import com.javaAcademy.OXGame.io.NetworkIO;
import com.javaAcademy.OXGame.io.UserIO;

import java.io.*;
import java.net.Socket;

public class TicTacToeClient {

    private BufferedReader in;
    private PrintWriter out;
    private UserIO userIO;
    private NetworkIO netIO;

    public TicTacToeClient() {

    }

    public void connectToServer() throws IOException {

        String serverAddress = "localhost";

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
//        in = new BufferedReader(
//                new InputStreamReader(socket.getInputStream()));
//        out = new PrintWriter(socket.getOutputStream(), true);

        userIO = new UserIO(System.out,System.in);

        netIO = new NetworkIO(new BufferedReader(new InputStreamReader(socket.getInputStream())),
                new PrintWriter(socket.getOutputStream(), true));

//        netIO = new NetworkIO(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));

        String responseRequiredPrefix = "RESPONSE_REQUIRED";
        String noResponsePrefix = "NO_RESPONSE";

        while(true){
            String input = netIO.read();
            if(input.startsWith(noResponsePrefix)){
                userIO.write(input.substring(noResponsePrefix.length()));
            }
            if (input.startsWith(responseRequiredPrefix)){
                netIO.write(userIO.writeAndRead(input.substring(responseRequiredPrefix.length())));
            }
        }
    }

    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        TicTacToeClient client = new TicTacToeClient();
        client.connectToServer();
    }
}
