package com.javaAcademy.OXGame;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserIO {
    private PrintStream printStream;
    private InputStream inStream;
    private Scanner scanner;

    public UserIO() {
        this.printStream = System.out;
        this.inStream = System.in;
        this.scanner = new Scanner(inStream);
    }

    public UserIO(PrintStream printStream, InputStream inStream) {
        this.printStream = printStream;
        this.inStream = inStream;
    }

    public void showUserMessage(String message){
        printStream.println(message);
    }

    public String getUserInput(){
        return scanner.nextLine();
    }

    public String userMessageWithInput(String message) {
        showUserMessage(message);
        return getUserInput();
    }
}
