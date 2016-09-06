package sample01.runnable.vs.thread;

public class SampleThreading {
    public static void main(String[] args) {
        BasedOnThread thread1 = new BasedOnThread();

        UsingRunnable usingRunnable = new UsingRunnable();
        Thread thread2 = new Thread(usingRunnable);

        thread1.start();
        thread2.start();
    }
}

class BasedOnThread extends Thread {
    private int counter = 10;
    @Override
    public void run() {
        while (counter > 0) {
            System.out.println(this.getClass().getName() + " " + counter);
            counter--;
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UsingRunnable implements Runnable {
    private int counter = 10;
    @Override
    public void run() {
        while (counter > 0) {
            System.out.println(this.getClass().getName() + " " + counter);
            counter--;
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}