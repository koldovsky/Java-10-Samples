package sample04.producer.consumer;

public class Runner {
    public static void main(String args[]) {
        Basket basket = new BasketNotSynchronized();
        //Basket basket = new BasketSynchronized();

        new Producer(basket);
        new Consumer(basket);
    }
}


