package lesson1;

public class Example02 {

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Interface " + Thread.currentThread().toString());
        }
    }

    public static void main(String[] args) {
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();

            new Thread(() -> {
                System.out.println("lambda " + Thread.currentThread().toString());
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Anonymous class " + Thread.currentThread().toString());
                }
            }).start();
    }

}
