package com.javaAcademy.OXGame.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserIO implements IO{
    private PrintStream printStream;
    private InputStream inStream;
    private Scanner scanner;

    public UserIO(){
        this.printStream = System.out;
        this.inStream = System.in;
        this.scanner = new Scanner(inStream);
    }

    public UserIO(PrintStream printStream, InputStream inStream) {
        this.printStream = printStream;
        this.inStream = inStream;
        this.scanner = new Scanner(inStream);
    }

    @Override
    public void write(String message){
        printStream.println(message);
    }

    @Override
    public String read(){
        return scanner.nextLine();
    }

    @Override
    public String writeAndRead(String message) {
        write(message);
        return read();
    }
}
