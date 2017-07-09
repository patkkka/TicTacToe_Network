package com.javaAcademy.OXGame.model;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.helper.UserIO;

/**
 * Created by patrycja on 09.07.17.
 */
public class PlayerSettings {
    private UserIO io;
    private MessageResolver msg;

    public PlayerSettings(UserIO io, MessageResolver msg) {
        this.io = io;
        this.msg = msg;
    }

    public UserIO getUserIo() {
        return io;
    }

    public MessageResolver getMsgResolver() {
        return new MessageResolver(msg);
    }
}
