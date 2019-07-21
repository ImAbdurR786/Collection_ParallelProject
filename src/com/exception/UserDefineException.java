package com.exception;

public class UserDefineException extends RuntimeException {

    public UserDefineException(String str) {
        System.out.println(str);
    }

}
