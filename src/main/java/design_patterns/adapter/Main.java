package design_patterns.adapter;

/**
 * @author: suruomo
 * @date: 2021/5/11 15:30
 * @description: 将VGA接口转换为HDMI接口
 */
public class Main {
    public static void main(String[] args) {
        VGA v=new HDMIAdapter();
        v.isVGA();
    }
}
