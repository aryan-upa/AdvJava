package MultiThreading;

/*
    This approach includes creating a Blocking Queue by ourselves and using that queue to store the data in the producer
    and consumer system.

    ---- THIS APPROACH USES THE CONCEPT OF LOCKS AND CONDITIONS ----
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyBlockingQueue<T> {
    // max is the queue size
    private final int max;

    // Queue in which the Items will be stored
    private final Queue<T> queue;

    // Lock which will be applied on the queue to ensure Producer-Consumer Scenario.
    private final ReentrantLock lock = new ReentrantLock(true);

    // notEmpty condition, to notify whether the queue is empty or not.
    private final Condition notEmpty = lock.newCondition();

    // notFull condition, to notify whether the queue is full or not.
    private final Condition notFull = lock.newCondition();

    public MyBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.max = size;
    }

    public void put(T e) throws InterruptedException {
        lock.lock();
        try {
            if(queue.size() == max) {
                notFull.wait();
            }
            queue.add(e);
            notEmpty.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            if(queue.size() == 0) {
                notEmpty.wait();
            }
            T item = queue.remove();
            notFull.signalAll();
            return item;
        }
        finally {
            lock.unlock();
        }
    }
}

class Item {
    static int i = 0;

    int packet1;
    String packet2;

    Item(int packet1, String packet2) {
        this.packet1 = packet1;
        this.packet2 = packet2;
    }

    synchronized static Item createItem() {
        System.out.println("Sent data : " + (i));
        return new Item(i++, String.valueOf(i));
    }

    synchronized static void process(Item item) {
        System.out.println("Got data : " + item.packet1);
    }

}

public class ProdCons2 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Item> queue = new MyBlockingQueue<>(10);

        // Producer
        final Runnable producer = () -> {
            while(true) {
                try {
                    Item sent = Item.createItem();
                    synchronized (queue) {
                        queue.put(sent);
                    }
                    Thread.sleep(50);
                    if(sent.packet1 > 15)
                        break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);
        p1.start();
        p2.start();

        // Consumer
        final Runnable consumer = () -> {
            while(true) {
                try {
                    synchronized (queue) {
                        Item received = queue.take();
                        Item.process(received);
                        if (received.packet1 > 15)
                            break;
                    }
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread c1 = new Thread(consumer);
        Thread c2 = new Thread(consumer);
        c1.start();
        c2.start();

        Thread.sleep(1000);

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        }
        catch (InterruptedException iE) {
            iE.printStackTrace();
        }
    }
}
