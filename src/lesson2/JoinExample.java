package lesson2;

import lesson1.Utils;

public class JoinExample {

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("start");
            Utils.pause(3000);
            System.out.println("finish");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        System.out.println("Thread started");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread end");
        System.out.println("Main end");

    }
}
