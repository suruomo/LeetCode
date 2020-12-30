package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/30 11:20
 * @description: 最小堆
 */
public class MinHeap {
    /**
     * 存放元素的动态数组
     */
    private List<Integer> list;
    /**
     * 堆的实际大小
     */
    private int size;

    /**
     * 初始化
     */
    public MinHeap() {
        list=new ArrayList<>();
        size=0;
        // 占位符，真正元素从下标1开始，因此list大小比size大1
        list.add(0);
    }

    public void offer(Integer x){
        // 堆大小加1
        size++;
        // hole表示新元素待插入位置，每次先插入队尾，然后进行上滤
        int hole=size;
        list.add(x);
        // x的值每次与父节点进行比较，若小于父节点，则上滤
        for (;hole>1&&x.compareTo(list.get(hole/2))<0;hole/=2){
            // 将父节点值放入当前位置
            list.set(hole,list.get(hole/2));
        }
        // 将x插入最终合适位置
        list.set(hole,x);
        System.out.println("当前插入值"+x+"的位置下标："+hole);
    }

    public Integer poll(){
        if (size==0){
            throw new NullPointerException("堆已空");
        }
        // 1.当前堆顶为最小元素
        int minItem=list.get(1);
        // 2.将堆尾元素移到堆顶
        list.set(1,list.get(size--));
        // hole为堆尾元素待插入新位置
        int hole=1;
        // 堆尾元素
        int temp=list.get(1);
        int child=0;
        // 3.下滤
        for (;hole*2<=size;hole=child){
            // 当前元素的左孩子
            child=hole*2;
            //如果左孩子比右孩子大，child++,从右边开始下滤
            if (child!=size&&list.get(child).compareTo(list.get(child+1))>0){
                child++;
            }
            //将较小的孩子结点的值放在父结点上,否则已经满足最小堆性质则break
            if (list.get(child).compareTo(temp)<0){
                list.set(hole,list.get(child));
                System.out.println("调整孩子"+list.get(child)+"至位置"+hole);
            }else {
                break;
            }
        }
        // 将调整元素放入最终位置
        list.set(hole,temp);
        return minItem;
    }
    public List getList() {
        return list.subList(1,size+1);
    }

    public int getCurrentSize() {
        return size;
    }

}
