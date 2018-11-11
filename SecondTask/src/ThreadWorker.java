

public class ThreadWorker extends Thread {

    volatile double d = 0;
    @Override
    public void run() {
        try {
            for (long l = 0; l < Long.MAX_VALUE; l++) {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is OK");
                }
                else {
                    break;
                }
                }
        } finally {
            System.out.println("thread ends");
        }
    }
}
