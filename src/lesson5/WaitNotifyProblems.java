package lesson5;

import lesson1.Utils;

public class WaitNotifyProblems {
    public static void main(String[] args) {
        Object pager = new Object();

        System.out.println("start");
        new Thread(() -> {
            synchronized (pager){
                try {
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("huuuuuy!");
        }).start();

        Utils.pause(1000);

        synchronized (pager){
            pager.notify();
            //якобы забыли выйти
            //и не отпускаем  монитор
            while (true){
            }
        }
    }
}
