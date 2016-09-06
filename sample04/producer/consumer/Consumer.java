package sample04.producer.consumer;

public class Consumer implements Runnable {
    Basket basket;

    Consumer(Basket basket) {
        this.basket = basket;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++ ) {
            basket.get();
        }
    }
}
