package parallel;

/**
 * @Author: suruomo
 * @Date: 2021/7/2 14:38
 * @Description: 两个线程打印数字
 */
public class PrintNumber {
    public volatile static int num=20;

    /**
     * 1.情况一：两个线程打印完数字即可不分顺序
     */
    public static class  Print1 implements Runnable{

        @Override
        public void run() {
            while (num>0){
                synchronized (this){
                    if (num>0){
                        System.out.println(Thread.currentThread().getName()+":"+num--);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    /**
     * 2.情况二：两个线程轮流交替打印数字
     */
    public static class  Print2 implements Runnable{

        @Override
        public void run() {
            while (num>0){
                synchronized (this){
                    notify();
                    if (num>0){
                        System.out.println(Thread.currentThread().getName()+":"+num--);
                        try {
                            Thread.sleep(100);
                            if (num>0){
                                wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("自由打印：");
//        Print1 print1=new Print1();
//        Thread thread1=new Thread(print1,"1号");
//        Thread thread2=new Thread(print1,"2号");
//        thread1.start();
//        thread2.start();
        System.out.println("交替打印：");
        Print2 print2=new Print2();
        Thread thread1=new Thread(print2,"1号");
        Thread thread2=new Thread(print2,"2号");
        thread1.start();
        thread2.start();
    }
}
