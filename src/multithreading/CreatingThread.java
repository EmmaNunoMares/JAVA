package multithreading;

public class CreatingThread {
    public static void main(String[] args) {
        new Thread(new PrintData()).start();
        new ReadInventoryThread().start();
    }

    public static class PrintData implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("print "+ i);
            }
        }
    }

    public static class ReadInventoryThread extends Thread {
        @Override
        public void run() {
            System.out.println("read inventory");
        }
    }
}
