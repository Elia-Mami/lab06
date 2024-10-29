package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{
    
    private static final String message = "Network error: no response";

    public NetworkException(){
        super(message);
    }
    public NetworkException(String errorMessage){
        super("Network error while sending message:" + errorMessage);
    }
}
