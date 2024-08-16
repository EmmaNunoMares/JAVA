package multithreading;

import java.util.concurrent.*;

public class CheckResults {
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        //test();
        test2();
    }

    public static void test2() throws Exception {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    CheckResults.count++;
                }
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached in time!!");
        } catch (TimeoutException e) {
            System.out.println("Not Reached in time!!");
        } finally {
            if (service != null) {
                service.shutdownNow();
            }
        }
    }

    public static void test() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                CheckResults.count++;
            }
        });
        while (CheckResults.count < 100) {
            System.out.println("Not reach yet");
            Thread.sleep(1000);
        }
        System.out.println("Reached!!!");
    }
}
