package design_patterns.adapter;

/**
 * @author: suruomo
 * @date: 2021/5/11 15:26
 * @description: 适配VGA接口的适配器
 */
public class HDMIAdapter extends HDMIImpl implements VGA{

    @Override
    public void isVGA() {
        isHDMI();
    }
}
