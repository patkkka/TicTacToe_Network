package com.javaAcademy.OXGame.io;

import java.io.IOException;

/**
 * Created by patrycja on 09.07.17.
 */
public interface IO {
    public String read() throws IOException;
    public void write(String msg);
    public String writeAndRead(String msg) throws IOException;
}
