package org.chase.brainfuck;

public class BrainfuckException extends RuntimeException {
    public BrainfuckException(String message) {
        super(message);
    }

    public BrainfuckException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrainfuckException(Throwable cause) {
        super(cause);
    }

    public BrainfuckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BrainfuckException() {
    }
}
