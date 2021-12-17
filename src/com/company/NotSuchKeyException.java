package com.company;

import java.util.NoSuchElementException;

public class NotSuchKeyException extends NoSuchElementException {
    int key;

    public NotSuchKeyException(int key) {
        this.key = key;
    }

    public NotSuchKeyException() {
    }

    public void printNotSuchKey(){
        System.out.println("Incorrect key " + key + ". Make correct choose.");
    }
}
