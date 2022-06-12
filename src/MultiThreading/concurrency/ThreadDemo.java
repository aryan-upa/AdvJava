package MultiThreading.concurrency;

public class ThreadDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            thread.join();
            System.out.println("File is ready to be Scanned!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void interruptionThread() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // the interrupt method doesn't actually stop a thread, it just requests the thread to interrupt.
        // To interrupt it, we actually have to check continuously whether any interrupt is requested or not.
        thread.interrupt();

        // Downloading will stop after 199045 bytes, as 1 sec is over.
    }

    public static void main(String[] args) {
        interruptionThread();
    }
}
