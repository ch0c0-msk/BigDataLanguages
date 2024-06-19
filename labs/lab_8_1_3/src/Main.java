import java.util.concurrent.locks.*;

class Shop {
    private int stock = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce(int quantity) {
        lock.lock();
        try {
            stock += quantity;
            System.out.println("Производитель поставил " + quantity + " товар(ов). Всего на складе: " + stock);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int quantity) throws InterruptedException {
        lock.lock();
        try {
            while (stock < quantity) {
                System.out.println("Товара в магазине не хватает. Подождите...");
                condition.await();
            }
            stock -= quantity;
            System.out.println("Покупатель забрал " + quantity + " товар(ов). Всего на складе: " + stock);
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int quantity = (int) (Math.random() * 5) + 1; // случайное количество товара от 1 до 5
                shop.produce(quantity);
                Thread.sleep(1000); // пауза для имитации времени производства
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int quantity = (int) (Math.random() * 3) + 1; // случайное количество товара от 1 до 3
                shop.consume(quantity);
                Thread.sleep(1500); // пауза для имитации времени покупки
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Producer producer = new Producer(shop);
        Consumer consumer = new Consumer(shop);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}