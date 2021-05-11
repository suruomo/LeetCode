package design_patterns.template;

/**
 * @author: suruomo
 * @date: 2021/5/11 14:58
 * @description: 模板模式
 */

/**
 * 模板类
 * @author 苏若墨
 */
public abstract class Template {
    public void templateMethods(){
        operation1();
        operation2();
        operation3();
    }

    public void operation1(){
        System.out.println("第一步");
    }

    public abstract void operation2();

    public abstract void operation3();
}

/**
 * 子类1实现模板
 */
class FirstTemplate extends Template{

    @Override
    public void operation2() {
        System.out.println("first的第二步");
    }

    @Override
    public void operation3() {
        System.out.println("first的第三步");
    }
}
/**
 * 子类2实现模板
 */
class SecondTemplate extends Template{

    @Override
    public void operation2() {
        System.out.println("second的第二步");
    }

    @Override
    public void operation3() {
        System.out.println("second的第三步");
    }
}


