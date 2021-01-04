package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/30 11:58
 * @description: 最大堆
 */
public class MaxHeap {
    private List<Integer> list;
    private int size;

    public MaxHeap() {
        list=new ArrayList<>();
        size=0;
        list.add(0);
    }

    public void offer(Integer x){
        size++;
        int hole=size;
        list.add(x);
        for (;hole>1&&x.compareTo(list.get(hole/2))>0;hole/=2){
            list.set(hole,list.get(hole/2));
        }
        list.set(hole,x);
    }

    public Integer poll(){
        if (size==0){
            throw new NullPointerException("堆已空");
        }
        int maxItem=list.get(1);
        list.set(1,list.get(size--));
        int hole=1;
        int temp=list.get(1);
        int child=0;
        for (;hole*2<=size;hole=child){
            child=hole*2;
            if (child<=size&&list.get(child).compareTo(list.get(child+1))<0){
                child++;
            }
            if (list.get(child).compareTo(temp)>0){
                list.set(hole,list.get(child));
                System.out.println("调整孩子"+list.get(child)+"至位置"+hole);
            }else {
                break;
            }
        }
        list.set(hole,temp);
        return maxItem;
    }
}
