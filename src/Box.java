///**
// * User: May
// * Date: 2015-04-02
// * Time: 20:19
// */
//class Consumer implements Runnable{
//    Box box;
//    public Consumer(Box box) {
//        this.box = box;
//    }
//    @Override
//    public void run() {
//        try {
//            while(!Thread.interrupted()){
//                synchronized (this) {
//                    while(box.size <=0){
//                        wait();
//                    }
//                }
//                synchronized (box.producer) {
//                    System.out.println("get a apple from box: size = " + --box.size);
//                    box.producer.notifyAll();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
//class Producer implements Runnable{
//    Box box;
//
//    public Producer(Box box) {
//        this.box = box;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while(!Thread.interrupted()){
//                synchronized (this) {
//                    while(box.size >=5){
//                        wait();
//                    }
//                }
//                synchronized (box.consumer) {
//                    System.out.println("put an apple in box:size = " + ++box.size);
//                    box.consumer.notifyAll();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//public class Box implements Runnable{
//
//    volatile int size = 0;
//    Producer producer = new Producer(this);
//    Consumer consumer = new Consumer(this);
//    @Override
//    public void run() {
//        new Thread(consumer).start();
//        new Thread(producer).start();
//    }
//
//    public static void main(String[] args) {
//        new Thread(new Box()).start();
//    }
//
//
//}