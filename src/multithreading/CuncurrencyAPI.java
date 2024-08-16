package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CuncurrencyAPI {
    public static void main(String[] args) {
        ExecutorService service = null;
        Runnable task1 = () -> System.out.println("Print zoo inventory");
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("record " + i);
            }
        };
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(task1);
            service.execute(task2);
            service.execute(task1);
            System.out.println("end");
        }finally {
            if(service!=null)service.shutdown();
        }
    }
}
