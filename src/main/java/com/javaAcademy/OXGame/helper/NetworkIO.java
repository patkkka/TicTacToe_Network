package com.javaAcademy.OXGame.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by patrycja on 08.07.17.
 */
public class NetworkIO {
    private BufferedReader in;
    private PrintWriter out;

    public NetworkIO(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public String read() throws IOException {
        return in.readLine();
    }

    public void write(String msg){
        out.println(msg);
    }

    public String writeAndRead (String msg) throws IOException {
        write(msg);
        return read();
    }
}
