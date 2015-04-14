/**
 * User: May
 * Date: 2015-04-02
 * Time: 20:34
 */

class MyProducer implements Runnable {

    MyBox myBox;
    public MyProducer(MyBox box) {
        this.myBox = box;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                if (myBox.apple >= 5) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (myBox.consumer){
                System.out.println("put an apple in box:size = " + ++myBox.apple);
                myBox.consumer.notifyAll();
            }

        }
    }
}

class MyConsumer implements Runnable {
    MyBox myBox;

    public MyConsumer(MyBox box) {
        this.myBox = box;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                if (myBox.apple <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (myBox.producer){
                System.out.println("get an apple in box:size = " + --myBox.apple);
                myBox.producer.notifyAll();
            }

        }
    }
}

public class MyBox implements Runnable{

    volatile int apple = 0;
    MyProducer producer = new MyProducer(this);
    MyConsumer consumer = new MyConsumer(this);
    @Override
    public void run() {
        new Thread(consumer).start();
        new Thread(producer).start();
    }

    public static void main(String[] args) {
        new Thread(new MyBox()).start();
    }
}
