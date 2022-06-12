package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
    This is a very simple approach using the Java's BlockingQueue DataStructure, it is a thread safe data structure so
    it implements most part of the Producer Consumer Problem by itself.

    Producer-Consumer Problem:
        There is a Queue which has some data in it.
        Producer produces the data and consumer consumes the data.
        We have to devise a solution so that at any given instant there may be no more than 1 producer in the queue, but
            there can be more than one consumer inside the queue.
        Also, if the queue is full the program should block the Producer process to produce until there is more space in
            the queue to add data. Similarly, if the queue is empty then the consumer should wait until the producer
            produces some data in the queue.
        We have to do all of this in a Thread-Safe Manner.
 */

public class ProdCons1 {

    static class Item {
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

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        // Producer
        final Runnable producer = () -> {
            while(true) {
                try {
                    Item sent = Item.createItem();
                    queue.put(sent);
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
                    Item received = queue.take();
                    Item.process(received);
                    Thread.sleep(50);
                    if (received.packet1 > 15)
                        break;
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
