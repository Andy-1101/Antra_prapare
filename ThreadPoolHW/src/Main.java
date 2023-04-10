import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception{

        // initiate threadPool
        MyThreadPool myThreadPool = new MyThreadPool(3);

        myThreadPool.addTask(() -> System.out.println("Task 1"));
        myThreadPool.addTask(() -> System.out.println("Task 2"));
        myThreadPool.addTask(() -> System.out.println("Task 3"));


        myThreadPool.shutDown();










    }
}