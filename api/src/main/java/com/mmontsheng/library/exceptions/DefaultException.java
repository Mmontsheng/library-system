package com.mmontsheng.library.exceptions;

public class DefaultException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public DefaultException() {
        super();
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }
}
