package lesson2;

import lesson1.Utils;

public class InterruptExample {

    static class Task implements Runnable {
        static long count = 0;

        @Override
        public void run() {
            while (true){
               count++;
               if(Thread.interrupted()){
                   System.out.println(count);
               }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        while (true){
            Utils.pause(500);
            thread1.interrupt();
        }

    }
}
