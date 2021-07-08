package lesson4;

import lesson1.Utils;

public class EvilCounterUsage {

    public static void main(String[] args) {
        Counter counter = new Counter();

        //Liveness
        //спасает lock
        //170705_02
        new Thread(() -> {
            synchronized (counter) {
                while (true) {

                }
            }
        }).start();

        Utils.pause(1000);

        System.out.println("Start new thread");

        new Thread(() -> {
            counter.inc();
            Utils.pause(1000);
        }).start();

        new Thread(() -> {
            System.out.println(counter.getCount());
            Utils.pause(1000);
        }).start();
    }
}
