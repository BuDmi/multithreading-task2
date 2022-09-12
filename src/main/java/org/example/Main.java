package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final List<MyCallableThread> myThreads = new ArrayList<>();

        myThreads.add(new MyCallableThread("поток 1", 6));
        myThreads.add(new MyCallableThread("поток 2", 5));
        myThreads.add(new MyCallableThread("поток 3", 4));
        myThreads.add(new MyCallableThread("поток 4", 7));

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("Ожидаю результатов всех задач...");
        final List<Future<Integer>> tasks = threadPool.invokeAll(myThreads);
        for (Future<Integer> task : tasks) {
            System.out.println("Очередной поток вывел в консоль " + task.get() + " сообщений");
        }

        System.out.println("Ожидаю результатов самой быстрой задачи...");
        System.out.println("Самый быстрый поток вывел в консоль " + threadPool.invokeAny(myThreads) + " сообщений");

        threadPool.shutdown();
    }
}