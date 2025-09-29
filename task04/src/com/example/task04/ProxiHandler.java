package com.example.task04;

import java.util.ArrayList;

public class ProxiHandler implements MessageHandler {


    private ArrayList<String> buffer = new ArrayList<>();
    private int MaxSize = 40;
    private MessageHandler handler = new ConsoleHandler();

    @Override
    public void Handle(String message) {
        if(buffer.size() < MaxSize){
            buffer.add(message);
        }
        else{
            for(String s : buffer){
                handler.Handle(s);
            }
            buffer.clear();
        }
    }
}
