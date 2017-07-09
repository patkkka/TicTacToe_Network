package com.javaAcademy.OXGame.model;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.io.IO;

/**
 * Created by patrycja on 09.07.17.
 */
public class PlayerSettings {
    private IO io;
    private MessageResolver msg;

    public PlayerSettings(IO io, MessageResolver msg) {
        this.io = io;
        this.msg = msg;
    }

    public IO getIO() {
        return io;
    }

    public MessageResolver getMsgResolver() {
        return new MessageResolver(msg);
    }
}
