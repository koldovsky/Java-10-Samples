package sample04.producer.consumer;

public class BasketNotSynchronized implements Basket {
    String fruit;

    public String get() {
        System.out.println("Got: " + fruit);
        return fruit;
    }

    public void put(String fruit) {
        this.fruit = fruit;
        System.out.println("Put: " + fruit);
    }
}
