package lesson5;

public class SimpleWorker {

    /**
     * Задача: чтобы simpleWorker был один
     * и последовательно выполняел задачи в одном созданном потоке
     * т е не создавал кадлый раз новый поток, а использовал имеющийся
     * @param task
     */
    public void process(Runnable task){
        new Thread(task).start();
    }
}
