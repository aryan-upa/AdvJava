package MultiThreading;

/*
    This implementation of Producer-Consumer problem is given in the "Java, The Complete Reference" book by
        Herbert Schildt.
     ---- IT USES THE WAIT AND NOTIFY APPROACH ----
 */

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet)
            try {
                wait();
            } catch (InterruptedException E) {
                System.out.println("InterruptException Caught!");
            }

        System.out.println("Got : " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException E) {
                System.out.println("InterruptedException Caught!");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put : " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i=0;
        while (true)
            q.put(i++);
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true)
            q.get();
    }
}

public class ProdCons3 {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
