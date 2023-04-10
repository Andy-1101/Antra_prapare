import static java.lang.Thread.currentThread;

public class MyThreadPool {
    private final MyBlockingQueue<Runnable> myBlockingQueue;
    private final MyThread[] myThreads;

    private volatile boolean running;

    public MyThreadPool(int numThreads){
        this.myBlockingQueue = new MyBlockingQueue<>(numThreads);
        this.myThreads = new MyThread[numThreads];
        this.running = true;

        int i = 0;
        for (MyThread t : myThreads){
            t = new MyThread("Thread " + i++);
            t.start();

        }
    }

    public void addTask(Runnable task){
        if(this.running) {
            try {
                myBlockingQueue.put(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void shutDown() {
        this.running = false;
        myBlockingQueue.running = false;

        try {
            for (Thread t : myThreads){
                t.stop();
            }
        } catch (Exception e){

            }
        }






    class MyThread extends Thread {
        public MyThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while (running) {
                try {
                    myBlockingQueue.poll().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
