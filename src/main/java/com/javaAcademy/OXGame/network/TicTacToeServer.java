package com.javaAcademy.OXGame.network;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.io.NetworkIO;
import com.javaAcademy.OXGame.io.UserIO;
import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;
import com.javaAcademy.OXGame.model.PlayerSettings;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by patrycja on 08.07.17.
 */
public class TicTacToeServer {
    private static GameSettings settings;
    private static GameStatistics statistics;

        public static void main(String[] args) throws Exception {
            System.out.println("TicTacToe server is running...");
            int clientNumber = 0;
            ServerSocket listener = new ServerSocket(9898);
            try {
                while (true) {
                    new PlayerHandler(listener.accept(), clientNumber++, settings, statistics).start();
                }
            } finally {
                listener.close();
            }
        }

        /**
         * A private thread to handle capitalization requests on a particular
         * socket.  The client terminates the dialogue by sending a single line
         * containing only a period.
         */
        private static class PlayerHandler extends Thread {
            private Socket socket;
            private int clientNumber;
            private NetworkIO netIO;
            private GameSettings settings;
            private GameStatistics statistics;
            private PlayerSettings playerSettings;

            public PlayerHandler(Socket socket, int clientNumber, GameSettings settings, GameStatistics statistics) {
                this.socket = socket;
                this.clientNumber = clientNumber;
                this.settings = settings;
                this.statistics = statistics;
                log("New connection with client # " + clientNumber + " at " + socket);
            }
            /**
             * Services this thread's client by first sending the
             * client a welcome message then repeatedly reading strings
             * and sending back the capitalized version of the string.
             */
            public void run() {
                try {
                    netIO = new NetworkIO(new BufferedReader(new InputStreamReader(socket.getInputStream())),
                            new PrintWriter(socket.getOutputStream(), true));

                    // Send a welcome message to the client.
                    netIO.write("Hello, you are client #" + clientNumber + ".\n");
                    netIO.write("Enter a line with only a period to quit\n");
                    final int lang = Integer.parseInt(netIO.writeAndRead(
                            "Please choose the language/Wybierz język: 1 - English, 2 - Polish"));
                    UserIO io = new UserIO(System.out,System.in);
                    MessageResolver msg = MessageResolver.createMessageResolver(lang);
                    playerSettings = new PlayerSettings(io, msg);

                    if(settings == null){
                        GameSettings settings = GameSettings.getGameSettings(playerSettings);
                                            }
                    if(statistics == null){
                        GameStatistics statistics = GameStatistics.getGameStatistics(playerSettings);
                    }

                    // Get messages from the client
                    while (true) {
                        String input = netIO.read();
                        if (input == null || input.equals(".")) {
                            break;
                        }
                        netIO.write(input.toUpperCase());
                    }
                } catch (IOException e) {
                    log("Error handling client #" + clientNumber + ": " + e);
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        log("Couldn't close a socket, what's going on?");
                    }
                    log("Connection with client #" + clientNumber + " closed");
                }
            }

            /**
             * Logs a simple message.  In this case we just write the
             * message to the server applications standard output.
             */
            private void log(String message) {
                System.out.println(message);
            }
        }
}
