package com.example.task04;

import java.time.temporal.ChronoUnit;

public enum HandleEnum {
    ConsoleHandle(new ConsoleHandler()),
    FileHandle(new FileHandler()),
    RotationFileHandle(new RotationFileHandler(ChronoUnit.SECONDS)),
    MemoryHandle(new ProxiHandler());
    private final MessageHandler _messageHandler;
    HandleEnum(MessageHandler messageHandler) {
        _messageHandler = messageHandler;
    }
    public MessageHandler getHandle(){
        return  _messageHandler;
    }

}

