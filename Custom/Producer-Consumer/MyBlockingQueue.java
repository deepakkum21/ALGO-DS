import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private int capacity;
    private Queue<Integer> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notFullCondition = lock.newCondition();
    private Condition notEmptyCondition = lock.newCondition();

    public MyBlockingQueue(int size) {
        queue = new LinkedList<>();
        capacity = size;
    }

    public void put(int item) {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                notFullCondition.wait();
            }
            queue.add(item);
            notEmptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        lock.lock();
        int item = 0;
        try {
            while (queue.size() == 0) {
                notEmptyCondition.wait();
            }
            item = queue.remove();
            notFullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }
}
