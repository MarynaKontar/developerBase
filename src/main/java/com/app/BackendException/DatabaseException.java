package com.app.BackendException;

/**
 * Created by User on 12.06.2017.
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException(Exception cause) {
        super(cause);
    }
}
