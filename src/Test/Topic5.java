package Test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Topic5 extends Thread {
    private int threadNo;
    public Topic5(int threadNo) {
        this.threadNo = threadNo;
    }
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 10; i++) {
            new Topic5(i).start();
        }
    }
    @Override
    public synchronized void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }
}
