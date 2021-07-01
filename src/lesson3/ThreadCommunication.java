package lesson3;

import static lesson1.Utils.pause;

public class ThreadCommunication {

    static final int STOP = 0;
    static final int STATE = 1;
    static final int NOP = -1;

    static int command = NOP;

    static class Task implements Runnable {
        static long count = 0;

        @Override
        public void run() {
          outer:  while (true) {
                count++;
                if (Thread.interrupted()) {
                    switch (command) {
                        case NOP:
                            break;
                        case STOP:
                            break outer;
                        case STATE:
                            System.out.println(count);
                            break;
                    }
                }
            }
            System.out.println(count);
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        pause(3000);
        System.out.println("interrupt 1");
        thread.interrupt();

        pause(3000);
        System.out.println("interrupt 2");
        command = STATE;
        thread.interrupt();

        pause(3000);
        System.out.println("interrupt 3");
        command = STOP;
        thread.interrupt();
    }
}
