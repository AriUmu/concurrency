package lesson5;

public class UseWorker {

    public static void main(String[] args) {
        SimpleWorker simpleWorker = new SimpleWorker();
        simpleWorker.process(() -> System.out.println("i did it"));
    }
}
