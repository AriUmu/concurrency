package lesson4;

import lesson1.Utils;

public class DeadLock {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a){
                Utils.pause(1000);
                synchronized (b){
                    System.out.println("Got it! ");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b){
                Utils.pause(1000);
                synchronized (a){
                    System.out.println("Got it! 2");
                }
            }
        }).start();
    }
}
