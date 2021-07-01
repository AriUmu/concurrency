package lesson3;

import static lesson1.Utils.pause;

public class ThreadCheckingVariable {

    volatile static boolean RUNNING = true;

    /**
     * проблема "видимости"
     * Поток скопировал значение RUNNING себе в память и работает с ее копией (кеширует)
     * ёпоэтому новое значение  RUNNING = false он не видит
     * надо добавлять слово volatile, но работать будет  медленнее
     */
    static class Task implements Runnable {
        static long count = 0;

        @Override
        public void run() {
               while (RUNNING){
                   count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        Thread thread = new Thread(new Task());
        thread.start();
        pause(3000);
        System.out.println("stop");
        RUNNING = false;
    }

}
