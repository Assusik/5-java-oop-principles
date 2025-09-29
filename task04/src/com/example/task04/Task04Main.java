package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {

        Logger logger2 = new Logger("log2",HandleEnum.ConsoleHandle);
        Logger logger1 = new Logger("log1",HandleEnum.FileHandle);
        Logger logger3 = new Logger("log3",HandleEnum.RotationFileHandle);
        Logger logger4 = new Logger("log4",HandleEnum.MemoryHandle);
        for(int i=0; i <= 41;i++){

            logger4.info("ASd");

        }
        for(;;) {

            logger3.info("ASd");
            }

        }
    }



