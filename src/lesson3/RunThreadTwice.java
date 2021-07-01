package lesson3;

public class RunThreadTwice {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.join();
        thread.start();

    }
}
