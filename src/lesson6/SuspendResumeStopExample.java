package lesson6;

import lesson1.Utils;

import javax.rmi.CORBA.Util;

public class SuspendResumeStopExample {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                Utils.pause(10_000);
                System.out.println("got it");
            }
        });
        thread.start();
        Utils.pause(1_000);
        thread.suspend();

    }
}
