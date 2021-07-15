package lesson6;

import java.util.LinkedList;
import java.util.Queue;

public class PoisonPill {
    private Queue<Runnable> tasks = new LinkedList<>();
    private static Runnable POISON_PILL = ()  -> {};
    private volatile boolean isRunning = true;

    public PoisonPill() {
        new Thread(this::process).start();
    }

    /**
     * POISON_PILL нужен для того чтобы не сразу прерывать выполнение потока
     * а дойти до POISON_PILL и только после этого завершить выполнение
     */
    private void shutdown(){
        tasks.add(POISON_PILL);
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
                    task = tasks.poll();
                }
                if(task == POISON_PILL){
                    break;
                }
                task.run();
            }
        }
    }

    public boolean submit(Runnable task){
        synchronized (tasks){
            if(!isRunning){
                return false;
            }
            if(task == POISON_PILL){
                isRunning = false;
            }
            tasks.add(task);
            tasks.notify();
        }
        return true;
    }
}
