import java.util.BitSet;

/**
 * @author: suruomo
 * @date: 2020/11/9 10:59
 * @description: 布隆过滤器
 * 需要：
 * 1.一个合适大小的位数组保存数据
 * 2.几个不同的哈希函数
 * 3.添加元素到位数组（布隆过滤器）的方法实现
 * 4.判断给定元素是否存在于位数组（布隆过滤器）的方法实现。
 */
public class MyBloomFilter {
    /**
     * 位数组默认大小
     */
    private static final int DEFAULT_SIZE=2<<24;
    /**
     * 可以用来创建6种不同的hash函数
     */
    private static final int[] SEEDS=new int[]{3,13,46,71,91,134};
    /**
     * 位数组
     */
    private BitSet bitSet=new BitSet(DEFAULT_SIZE);
    /**
     * 存放hash函数的数组
     */
    private SimpleHash[] funcs=new SimpleHash[SEEDS.length];

    /**
     * 构造函数：创建多种hash函数，存放于数组
     */
    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            funcs[i]=new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    /**
     * 添加元素
     * @param value
     */
    public void add(Object value){
        for (SimpleHash func:funcs) {
            bitSet.set(func.hash(value));
        }
    }

    /**
     * 判断元素是否存在
     * @param value
     * @return
     */
    public boolean contains(Object value){
        boolean ret = true;
        // 用每种hash函数判断是否都存在
        for (SimpleHash f : funcs) {
            ret = ret && bitSet.get(f.hash(value));
        }
        return ret;
    }


    /**
     * 静态内部类，用于计算hash值
     */
    public static class SimpleHash{
        private int size;
        private int seed;

        public SimpleHash(int size, int seed) {
            this.size = size;
            this.seed = seed;
        }


        /**
         * 计算hash值
         * @param key
         * @return
         */
        public int hash(Object key){
            int h;
            // key.hashCode()：返回散列值也就是hashcode
            // ^ ：按位异或
            // >>>:无符号右移，忽略符号位，空位都以0补齐
            return (key==null)?0:(seed *(size-1))&((h=key.hashCode())^(h>>>16));
        }
    }
}
