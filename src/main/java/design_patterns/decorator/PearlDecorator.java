package design_patterns.decorator;

/**
 * @Author: suruomo
 * @Date: 2021/7/21 12:46
 * @Description: 珍珠装饰器
 */
public class PearlDecorator extends Decorator{
    public PearlDecorator(TeaWithMilk teaWithMilk) {
        super(teaWithMilk);
    }
    @Override
    public void operation() {
        teaWithMilk.operation();
        addPearl();
    }

    private void addPearl() {
        System.out.println("加珍珠");
    }
}
