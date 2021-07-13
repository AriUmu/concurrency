package lesson5;

import java.util.LinkedList;
import java.util.Queue;

public class WorkingThread {

    /**
     * любые изменения и проверки состояния объекта должны находится
     * в критической секции
     */
    private Queue<Runnable> tasks = new LinkedList<>();

    public WorkingThread() {
        new Thread(this::process).start();
    }

    private void process() {
        while (true){
            Runnable task = null;
            synchronized (tasks) {
            /*
            нужно помещать внурть цикла чтобы избезать "спонтанного пробуждения" spurious wakeup java thread
             */
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = tasks.poll();
            }
            task.run();
        }
    }

    public void submit(Runnable task){
        synchronized (tasks){
            tasks.add(task);
            tasks.notify();
        }
    }
}
