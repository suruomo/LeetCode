package design_patterns.singleton;

/**
 * @author: suruomo
 * @date: 2021/5/11 15:06
 * @description: 单例模式：双重检验
 */
public class Singleton {
    // volatile关键字避免指令重排
    private volatile static Singleton instance;

    private Singleton(){};

    public Singleton getInstance(){
        // 1.第一次判空，避免加锁开销
        if (instance==null){
            synchronized (Singleton.class){
                // 2.第二次判空，可能情况：A线程进入同步块还未创建对象，时间片已到，B线程进入同步块
                // 若不判空，则B线程创建对象后，A又创建一个对象则不满足。
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
