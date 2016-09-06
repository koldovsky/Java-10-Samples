package sample04.producer.consumer;

public class Producer implements Runnable {
    Basket basket;
    String[] fruits = {"Apple", "Orange", "Lemon", "Cherry",
      "Plum", "Apricot", "Peach"};

    Producer(Basket b) {
        this.basket = b;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (String f: fruits) {
            basket.put(f);
        }
    }
}
