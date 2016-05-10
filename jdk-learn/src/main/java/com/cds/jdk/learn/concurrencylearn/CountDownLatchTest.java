package com.cds.jdk.learn.concurrencylearn;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPortion implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private static Random rand = new Random(47);

    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
       try {
           doWork();
           latch.countDown();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
        System.out.println(this + "completed");
    }

    public String toString() {
        return String.format("%1$-3d", id);
    }
}

class WaitingTask implements Runnable {
    private static int counter = 0;

    private final int id = counter++;

    private final CountDownLatch latch;

    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
       try{
           latch.await();
           System.out.println("Latch barrier passed for" + this);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    public String toString() {
       return String.format("WaitingTask %1$-3d", id);
    }
}
public class CountDownLatchTest {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);

        for (int i = 0; i < 10 ; i++) {
           executorService.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE ; i++) {
           executorService.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        executorService.shutdown();
    }
}
