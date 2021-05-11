package design_patterns.adapter;

/**
 * @author: suruomo
 * @date: 2021/5/11 15:25
 * @description: 一种HDMI实现类
 */
public class HDMIImpl implements HDMI{

    @Override
    public void isHDMI() {
        System.out.println("这是HDMI接口");
    }
}
