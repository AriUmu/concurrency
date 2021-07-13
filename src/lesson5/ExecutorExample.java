package lesson5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 170711
 */
public class ExecutorExample {
    public static void main(String[] args) {
        Executor services = Executors.newSingleThreadExecutor();
        services.execute(() -> System.out.println("Start"));
        services.execute(() -> System.out.println("wait"));
        services.execute(() -> System.out.println("stop"));
    }
}
