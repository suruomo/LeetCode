package design_patterns.decorator;

/**
 * @Author: suruomo
 * @Date: 2021/7/21 12:50
 * @Description: 测试
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("普通原味奶茶：");
        TeaWithMilk teaWithMilk=new PureTeaMilk();
        teaWithMilk.operation();
        System.out.println("加珍珠的原味奶茶：");
        TeaWithMilk pearl=new PearlDecorator(new PureTeaMilk());
        pearl.operation();
    }
}
