package heap;

import java.util.ArrayList;

/**
 * 堆
 * @author 苏若墨
 */
public class Heap<T extends Comparable<? super T>> {
    private ArrayList<T> list;
    private int currentSize=0;

    /**
     * 数组初始化，下标0的位置存放一位用来占位
     * @param x 占位符
     */
    public Heap(T x) {
        this.list=new ArrayList<>();
        this.list.add(x);
    }

    /**
     * 插入
     * @param x 待插入元素
     */
    public void insert(T x){
        currentSize++;
        //空位为当前堆大小加一
        int hole=currentSize;
        //上滤法
        for(;hole>1&&x.compareTo(list.get(hole/2))<0;hole/=2) {
            //当前size已满，使用add追加元素，否则使用set
            if(currentSize==list.size()){
                list.add(hole,list.get(hole/2));
            }
            else{
                list.set(hole,list.get(hole/2));
            }
        }
        if(currentSize==list.size()){
            list.add(hole,x);
        }
        else{
            list.set(hole,x);
        }
        System.out.println("当前插入值"+x+"的位置下标："+hole);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public int getCurrentSize() {
        return currentSize;
    }


}
