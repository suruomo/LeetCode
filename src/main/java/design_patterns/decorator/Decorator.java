package design_patterns.decorator;

/**
 * @Author: suruomo
 * @Date: 2021/7/21 11:50
 * @Description: 装饰器，用来装饰奶茶
 */
public class Decorator implements TeaWithMilk{
    protected TeaWithMilk teaWithMilk;

    public Decorator(TeaWithMilk teaWithMilk) {
        this.teaWithMilk = teaWithMilk;
    }

    @Override
    public void operation() {
        teaWithMilk.operation();
    }
}
