package parallel;

/**
 * @author suruomo
 * @date 2020/7/22 16:38
 * @description: 三个线程按序执行
 */
public class Foo {


    static class One implements Runnable{

        @Override
        public void run() {
            System.out.println("One");
        }
    }
    static class Second implements Runnable{

        @Override
        public void run() {
            System.out.println("Second");
        }
    }
    static class Third implements Runnable{

        @Override
        public void run() {
            System.out.println("Third");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new One());
        Thread thread2=new Thread(new Second());
        Thread thread3=new Thread(new Third());
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
