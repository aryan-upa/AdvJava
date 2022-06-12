package MultiThreading;

public class Threading {
    public static void main(String[] args) {
        // no. of active threads
        System.out.println(Thread.activeCount());

        // no. of available processors in the system.
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
