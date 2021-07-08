package lesson4;

public class SyncMultiThread {
    synchronized void change() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().toString());
        }
    }

    public static void main(String[] args) {
        SyncMultiThread sync = new SyncMultiThread();

        new Thread(() -> {
            sync.change();
        }, "MyThread1").start();
        new Thread(() -> {
            sync.change();
        }, "MyThread2").start();
        new Thread(() -> {
            sync.change();
        }, "MyThread3").start();

        sync.change();
    }
}
