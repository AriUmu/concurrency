package lesson1;

public class Example03 {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().toString());
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
