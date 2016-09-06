package sample01.runnable.vs.thread;

public class SampleYield {
    public static void main(String[] args) {
        ThreadWithYield thread1 = new ThreadWithYield();
        ThreadWithoutYield thread2 = new ThreadWithoutYield();

        thread1.start();
        thread2.start();
    }
}

class ThreadWithYield extends Thread {
    private int counter = 10;
    @Override
    public void run() {
        while (counter > 0) {
            System.out.println(this.getClass().getName() + " " + counter);
            counter--;
            yield();
        }
    }
}

class ThreadWithoutYield extends Thread {
    private int counter = 10;
    @Override
    public void run() {
        while (counter > 0) {
            System.out.println(this.getClass().getName() + " " + counter);
            counter--;
        }
    }
}


