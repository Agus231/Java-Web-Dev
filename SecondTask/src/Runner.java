import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ThreadWorker());
        thread.start();
        thread.interrupt();
        Thread.sleep(10000);
    }

}



