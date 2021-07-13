package lesson5;

import lesson1.Utils;

public class WaitNotifyExamples {

    static class Task implements Runnable {
        private Object pager;

        public Task(Object pager) {
            this.pager = pager;
        }

        @Override
        public void run() {
            synchronized (pager) {
                try {
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Started!");
        Object pager = new Object();
        new Thread(new WaitNotifyExamples.Task(pager)).start();
        Utils.pause(2000);

        /*
        Перед pager.notify(); нужно захватить pager в монопольное использование
        чтобы удедиться что никто кроме этого потока не имеет доступа к объекту
        Решает проблему работающего ядра в холостую
         */
        synchronized (pager){
            pager.notify();
        }
    }
}
