package com.example.springftp.domain;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String msg) {
        super(msg);
    }

    public FileNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
