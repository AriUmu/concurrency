package lesson5;

import lesson1.Utils;

public class UseWorkerThread {
    public static void main(String[] args) {
        WorkingThread workingThread = new WorkingThread();
        workingThread.submit(() -> {
            System.out.println("start" + Thread.currentThread());
            Utils.pause(1000);
            System.out.println("stop");
        });

        workingThread.submit(() -> {
            System.out.println("start" + Thread.currentThread());
            Utils.pause(1000);
            System.out.println("stop");
        });
    }
}
