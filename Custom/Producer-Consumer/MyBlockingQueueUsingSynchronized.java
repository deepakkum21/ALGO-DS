import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueUsingSynchronized {
    private int capacity;
    private Queue<Integer> queue = new LinkedList<>();
    private Object notFull = new Object();
    private Object notEmpty = new Object();

    public MyBlockingQueueUsingSynchronized(int size) {
        queue = new LinkedList<>();
        capacity = size;
    }

    public synchronized void put(int item) {
        try {
            if (queue.size() == capacity) {
                notFull.wait();
            }
            queue.add(item);
            notEmpty.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int take() {
        int item = 0;
        try {
            while (queue.size() == 0) {
                notEmpty.wait();
            }
            item = queue.remove();
            notFull.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return item;
    }
}
