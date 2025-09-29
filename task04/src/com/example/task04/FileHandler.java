package com.example.task04;

import javax.imageio.IIOException;
import java.io.*;

public class FileHandler implements MessageHandler {
    private String fileName = "logFile";
    public FileHandler() {

    }
    public FileHandler(String name) {
        fileName = name;
    }
    @Override
    public void Handle(String message) {
        try {
            PrintWriter pw = new PrintWriter( new FileWriter(fileInit(fileName),true) );
            pw.println(message);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private File fileInit(String name){
        File file = new File(String.format("task04/%s.txt",name));
        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        return file;
    }
}
