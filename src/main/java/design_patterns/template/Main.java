package design_patterns.template;

/**
 * @author: suruomo
 * @date: 2021/5/11 15:04
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Template firstTemplate=new FirstTemplate();
        firstTemplate.templateMethods();
        Template secondTemplate=new SecondTemplate();
        secondTemplate.templateMethods();
    }
}
