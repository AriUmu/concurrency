package lesson4;

/**
 * lock -> monitor ->   object
 * блокируется не метод, а объект блокировки
 *
 */
public class Sync {

//    static void change(){
//        synchronized (Sync.class){
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i +  " " + Thread.currentThread().toString());
//            }
//        }
//    }

    synchronized void change() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().toString());
        }
    }

    public static void main(String[] args) {
        Sync sync = new Sync();

        new Thread(() -> {
            sync.change();
        }, "MyThread").start();

        sync.change();
    }
}
