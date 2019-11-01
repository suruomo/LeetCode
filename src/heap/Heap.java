package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小二叉堆
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
     * 上滤法调整堆
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

    /**
     * 删除最小元素，即堆顶
     * 下滤法调整堆
     */
    public void deleteMin(){
       if(currentSize==0){
           throw new NullPointerException("堆已空");
       }
       //1.取当前堆顶元素，即最小元素
       T minTItem=list.get(1);
       //2.将堆顶元素设置为堆尾元素
        list.set(1,list.get(currentSize--));
        System.out.println("位置1："+list.get(1));
        System.out.println("cureentSize："+currentSize);
       //3.从堆顶开始，下滤法
        percolate(1);
    }

    private void percolate(int hole) {
        int child=0;
        T temp=list.get(hole);
        for(;hole*2<=currentSize;hole=child){
            //当前结点左孩子
            child=hole*2;
            //如果左孩子比右孩子大，child++,从右边开始下滤
            if(child!=currentSize&&list.get(child).compareTo(list.get(child+1))>0){
                child++;
            }
            //将较小的孩子结点的值放在父结点上,否则已经满足最小堆性质则break
            if(list.get(child).compareTo(temp)<0){
                list.set(hole,list.get(child));
                System.out.println("调整孩子"+list.get(child)+"至位置"+hole);
            }
            else{
                break;
            }
        }
        list.set(hole,temp);
    }

    public List<T> getList() {
        return list.subList(1,currentSize+1);
    }

    public int getCurrentSize() {
        return currentSize;
    }


}
