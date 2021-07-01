package lesson2;

import lesson1.Utils;

public class DeamonExample {

    static class Task implements Runnable {
        static int count = 0;

        @Override
        public void run() {
            System.out.println("start");

            while (true){
                Utils.pause(1000);
                System.out.println(++count);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.setDaemon(true);
        thread1.start();
        Utils.pause(5000);
        System.out.println("Main stopped");

    }
}
