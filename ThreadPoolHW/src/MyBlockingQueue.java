import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<Runnable> {

    private Object[] arr;
    private int size;
    private final ReentrantLock lock = new ReentrantLock();
    public final Condition full = lock.newCondition();
    public final Condition empty = lock.newCondition();
    private int start = 0;
    private int end = 0;
    public boolean running = true;

    public MyBlockingQueue(int capacity){
        this.arr = new Object[capacity];
    }

    public void put(Runnable ele) throws Exception {
        if (running) {

            lock.lock();
            try {
                while (size == arr.length) {
                    full.await();
                }


                arr[end] = ele;
                end += 1;
                if (end == arr.length) {
                    end = 0;
                }

                size += 1;
                empty.signal();

            } finally {
                lock.unlock();
            }

        }
    }

    public Runnable poll() throws Exception {

            lock.lock();

            try {
                while (size == 0) {
                    empty.await();
                }


                Runnable res = (Runnable) arr[start];
                start += 1;

                if (start == arr.length) {
                    start = 0;
                }

                size -= 1;

                full.signal();
                return res;

            } finally {
                lock.unlock();
            }

        }




}

