package sample02.wait;

public class WaitAnother {

    public static void main(String[] args) {
        SampleThread t1 = new SampleThread("Thread 1", null);
        SampleThread t2 = new SampleThread("Thread 2", t1);
        SampleThread t3 = new SampleThread("Thread 3", t2);
        SampleThread t4 = new SampleThread("Thread 4", t2);

        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }

}

class SampleThread extends Thread {
    Thread waitFor;
    SampleThread (String name, Thread waitFor) {
        setName(name);
        this.waitFor = waitFor;
    }

    @Override
    public void run() {
        sleepRandom();
        System.out.println(getName() + " started");
        if (waitFor != null) {
            System.out.println(getName() + " waiting for " + waitFor.getName());
            try {
                waitFor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " finished");
    }

    void sleepRandom() {
        try {
            Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}