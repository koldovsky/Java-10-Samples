package sample04.producer.consumer;

public class BasketSynchronized implements Basket {
    String fruit;
    boolean fruitLaid;

    public synchronized String get() {
        if (!fruitLaid) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Got: " + fruit);
        fruitLaid = false;
        notify();
        return fruit;
    }

    public synchronized void put(String fruit) {
        if (fruitLaid) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.fruit = fruit;
        fruitLaid = true;
        System.out.println("Put: " + fruit);
        notify();
    }
}
