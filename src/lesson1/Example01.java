package lesson1;

public class Example01 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.toString());

        Thread thread2 = new Thread(() -> {
            System.out.println("Hello!");
            System.out.println(Thread.currentThread().toString());
        });
        thread2.start();

        System.out.println("main finished");
    }
}
