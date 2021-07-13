package lesson5;

import lesson1.Utils;

public class NaiveMessagePassing {

    /**
     * volatile решает проблему visibility но при этом
     * целое ядро будет занято
     */
    static volatile boolean ready = false;

    static class Task implements Runnable {

        @Override
        public void run() {
            while (!ready) {
            }
            System.out.println("Got ot!");
        }
    }


    public static void main(String[] args) {
        System.out.println("Started!");
        new Thread(new Task()).start();
        Utils.pause(2000);
        ready = true;
    }
}
