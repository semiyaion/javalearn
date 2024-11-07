package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        print(1);
        print("123");

    }
    private static <T> void print(T content){
        System.out.println(content);
    }
}