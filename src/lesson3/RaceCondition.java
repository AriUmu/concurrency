package lesson3;

import static lesson1.Utils.pause;

/**
 * состояние гонки 170331
 * - когда несколько потоков меняют значение общей памяти
 * read-modify-write
 */
public class RaceCondition {

    static int count = 0;

    static class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
               pause(1000);
                inc();
            }
        }

        // == synchronized(this)
//        synchronized private void inc() {
//            count++;
//            System.out.println(count);
//        }


        /**
         * mutex = монитор - любой объект
         * критическая секция регулируется монитором
         */
        private void inc() {
             synchronized(this) {
                 count++;
                 System.out.println(count);
             }

        }
    }

    public static void main(String[] args) {
        Task target = new Task();
        Thread thread = new Thread(target);
        Thread thread2 = new Thread(target);
        thread.start();
        thread2.start();
    }
}
