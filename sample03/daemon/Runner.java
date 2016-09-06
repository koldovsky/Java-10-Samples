package sample03.daemon;

public class Runner {
    public static void main(String[] args) {
        SampleThread notDaemon1 = new SampleThread(false, 5000);
        SampleThread notDaemon2 = new SampleThread(false, 7000);
        SampleThread daemon1 = new SampleThread(true, 10000);
        SampleThread daemon2 = new SampleThread(true, 20000);

        notDaemon1.start();
        notDaemon2.start();
        daemon1.start();
        daemon2.start();
    }
}

class SampleThread extends Thread {
    int waitMSecs;
    SampleThread(boolean isDaemon, int waitMSecs) {
        setDaemon(isDaemon);
        this.waitMSecs = waitMSecs;
    }

    @Override
    public void run() {
        String msg = isDaemon() ? "Daemon" : "Not Daemon";
        System.out.println("Started " + msg);
        System.out.println("Waiting for " + waitMSecs);
        try {
            sleep(waitMSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished " + msg);
    }
}
