package string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * 内容：测试输入一个包含括号的字符串是否有效
 * 方法：使用参数化测试，使用不同的值反复运行同一个测试
 * 步骤1：指定参数运行器
 */
@RunWith(Parameterized.class)
public class IsValidTest {
    /**
     * 步骤2：声明变量
     */
    private String inputStr;
    private Boolean expectedResult;
    private IsValid valid;

    /**
     * 步骤3：创建构造函数，初始化
     * @param inputStr 输入字符串
     * @param expectedResult 预期结果
     */
    public IsValidTest(String inputStr, Boolean expectedResult) {
        this.inputStr = inputStr;
        this.expectedResult = expectedResult;
    }

    /**
     * 为测试类声明一个使用注解 org.junit.runners.Parameterized.Parameters 修饰的，
     * 返回值为java.util.Collection 的公共静态方法
     *           1）该方法必须由Parameters注解修饰
     *           2）该方法必须为public static的
     *           3）该方法必须返回Collection类型
     *           4）该方法的名字不做要求
     *           5）该方法没有参数

     * @return
     */
    @Parameterized.Parameters
   public static Collection isValid(){
       return Arrays.asList(new Object[][]{
               {"[[]]", true},
               {"[", false},
               {"", true},
               {"[]]", false},
               {"([])", true}
       });
   }
    @Before
    public void initialize() {
        valid = new IsValid();
    }

    /**
     * 步骤5：编写测试方法
     */
    @Test()
    public void main() {
        System.out.println("输入字符串: " + inputStr);
        Assert.assertEquals(expectedResult, valid.isValid(inputStr));
    }
}