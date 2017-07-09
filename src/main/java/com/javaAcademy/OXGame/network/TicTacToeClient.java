//package com.javaAcademy.OXGame.network;
//
//import com.javaAcademy.OXGame.helper.NetworkIO;
//import com.javaAcademy.OXGame.helper.UserIO;
//
//import javax.swing.*;
//import java.io.*;
//import java.net.Socket;
//
//public class TicTacToeClient {
//
//    private BufferedReader in;
//    private PrintWriter out;
//    private UserIO userIO;
//    private NetworkIO netIO;
//
//    public TicTacToeClient() {
//
//    }
//
//    public void connectToServer() throws IOException {
//
//        String serverAddress = "localhost";
//
//        // Make connection and initialize streams
//        Socket socket = new Socket(serverAddress, 9898);
////        in = new BufferedReader(
////                new InputStreamReader(socket.getInputStream()));
////        out = new PrintWriter(socket.getOutputStream(), true);
//
//        userIO = new UserIO(System.out,System.in);
//
//        netIO = new NetworkIO(new BufferedReader(new InputStreamReader(socket.getInputStream())),
//                new PrintWriter(socket.getOutputStream(), true));
//
////        netIO = new NetworkIO(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
//
//        // Consume the initial welcoming messages from the server
//        for (int i = 0; i < 3; i++) {
//            userIO.showUserMessage(netIO.read());
//        }
//
////        while(true){
////
////        }
//    }
//
//    /**
//     * Runs the client application.
//     */
//    public static void main(String[] args) throws Exception {
//        TicTacToeClient client = new TicTacToeClient();
//        client.connectToServer();
//    }
//}
