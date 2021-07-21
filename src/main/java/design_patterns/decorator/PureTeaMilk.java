package design_patterns.decorator;

/**
 * @Author: suruomo
 * @Date: 2021/7/21 11:49
 * @Description: 原味奶茶，实现奶茶接口
 */
public class PureTeaMilk implements TeaWithMilk{
    @Override
    public void operation() {
        System.out.println("冲泡一杯原味奶茶");
    }
}
