package com.cds.jdk.learn.hooklearn;

/**
 * 应用程序正常退出，在退出时执行特定的业务逻辑，或者关闭资源等操作。
 * 虚拟机非正常退出，比如用户按下ctrl+c、OutofMemory宕机、操作系统关闭等。在退出时执行必要的挽救措施。
 * 建议：同一个JVM最好只使用一个关闭钩子，而不是每个服务都使用一个不同的关闭钩子，
 * 使用多个关闭钩子可能会出现当前这个钩子所要依赖的服务可能已经被另外一个关闭钩子关闭了。
 * 为了避免这种情况，建议关闭操作在单个线程中串行执行，从而避免了再关闭操作之间出现竞态条件或者死锁等问题。
 */
public class HookTest {

    public static void start() {
        System.out.println("The JVM is started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    //do something
                    System.out.println("The JVM Hook is execute");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void testRuntime() {
        System.out
            .println("The available Processors is :" + Runtime.getRuntime().availableProcessors());
        System.out.println("The free memory is :" + Runtime.getRuntime().freeMemory());
        System.out.println("The max memory is : " + Runtime.getRuntime().maxMemory());
        System.out.println("The total memory is : " + Runtime.getRuntime().totalMemory());
    }

    public static void main(String[] args) {
        testRuntime();

        start();
        System.out.println("The Application is doing something");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
