package org.example;

import java.util.concurrent.Callable;


public class MyCallableThread implements Callable<Integer> {

    private String name;
    private int messagesNum;

    public MyCallableThread(String name, int messagesNum) {
        this.name = name;
        this.messagesNum = messagesNum;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < messagesNum; i++) {
            Thread.sleep(2500);
            System.out.println("Я " + name + ". Всем привет!");
        }
        return messagesNum;
    }
}