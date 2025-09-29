package com.example.task04;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {

    private String _name = "Logger";
    private MessageHandler _messageHandler;
    private static ArrayList<Logger> _loggers = new ArrayList<Logger>();
    private LogLevel _logLevel = LogLevel.DEBUG;

    public Logger(String name) {
        _name = name;
    }
    public Logger(String name, HandleEnum handleType) {
        _name = name;
        _messageHandler = handleType.getHandle() ;
    }

    public String getName(){
        return _name;
    }
    public static Logger getLogger(String name){
        for(int i= 0; i< _loggers.toArray().length;i++){
            if(_loggers.get(i).getName().equals(name)){
                return _loggers.get(i);
            }

        }
        Logger logger = new Logger(name);
        _loggers.add(logger);
        return logger;
    }
    public LogLevel getLevel(){
        return _logLevel;
    }
    public void setLevel(LogLevel logLevel){
        _logLevel = logLevel;
    }
    public void error(String message){
    log(LogLevel.ERROR, message);
    }
    public void error(String format, Object... args){
    log(LogLevel.ERROR, format, args);
    }
    public void warning(String message){
        log(LogLevel.WARNING, message);
    }
    public void warning(String format, Object... args){
        log(LogLevel.WARNING, format, args);
    }
    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void info(String format, Object... args){
        log(LogLevel.INFO, format, args);
    }
    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void debug(String format, Object... args){
        log(LogLevel.DEBUG,format,args);
    }
    public void log(LogLevel logLevel, String message){

        if(logLevel.compareTo(_logLevel) >= 0){
            _messageHandler.Handle(formatMessage(logLevel, message));
        }
    }
    public void log(LogLevel logLevel, String format, Object... args){

        if(logLevel.compareTo(_logLevel) >= 0){

            _messageHandler.Handle(formatMessage(logLevel, String.format(format, args)));
        }
    }

    private String formatMessage(LogLevel logLevel, String Message){
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

        return String.format("[%s] %s  %s - %s", logLevel.name(), date, this._name, Message);
    }

}
