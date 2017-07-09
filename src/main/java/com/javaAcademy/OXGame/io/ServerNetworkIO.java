package com.javaAcademy.OXGame.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by patrycja on 08.07.17.
 */
public class ServerNetworkIO implements IO{
    private BufferedReader in;
    private PrintWriter out;

    public ServerNetworkIO(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public String read() throws IOException {
        return in.readLine();
    }

    @Override
    public void write(String msg){
        out.println("NO_RESPONSE" + msg);
    }

    @Override
    public String writeAndRead (String msg) throws IOException {
        out.println("RESPONSE_REQUIRED" + msg);
        return read();
    }
}
