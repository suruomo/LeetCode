package parallel;

/**
 * @author suruomo
 * @date 2020/7/22 16:38
 * @description: 按序打印
 * 三个不同的线程将会共用一个 Foo 实例。
 * 以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class Foo {
    public Foo( ) {
    }

    public static class First implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                System.out.println("first");
            }
        }
    }
    public static class Second implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                System.out.println("second");
            }
        }
    }
    public static class Third implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                System.out.println("third");
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable1=new First();
        Runnable runnable2=new Second();
        Runnable runnable3=new Third();
        runnable1.run();
        runnable2.run();
        runnable3.run();
    }
}
