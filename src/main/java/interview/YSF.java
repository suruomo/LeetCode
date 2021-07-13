package interview;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * @Author: suruomo
 * @Date: 2021/7/13 11:33
 * @Description: 环形链表的约瑟夫问题
 * 编号为 11 到 nn 的 nn 个人围成一圈。从编号为 11 的人开始报数，报到 mm 的人离开。
 * 下一个人继续从 11 开始报数。
 * n-1n−1 轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？
 */
public class YSF {
    /**
     * 1.使用java提供链表
     * @param n
     * @param m
     * @return
     */
    public int ysf (int n, int m) {
        LinkedList<Integer> list=new LinkedList<>();
        if(m<1 || n<1){
            return -1;
        }
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int bt=0;
        while(list.size()>1){
            bt=(bt+m-1)%list.size();
            list.remove(bt);
        }
        return list.get(0)+1;
    }
    public class LinkedNode{
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    /**
     * 2.使用自己构造链表
     * @param n
     * @param m
     * @return
     */
    public int ysf1 (int n, int m) {
        if (n<1||m<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        // 构造单向环形链表
        LinkedNode head=new LinkedNode(1);
        LinkedNode tail=head;
        for (int i = 2; i <=n; i++) {
            tail.next=new LinkedNode(n);
            tail=tail.next;
        }
        tail.next=head;
        // 遍历
        LinkedNode cur=head;
        LinkedNode pre=tail;
        int index=0;
        while (cur.next!=null&&cur.next!=cur){
            index++;
            LinkedNode next=cur.next;
            if (index==m){
                pre.next=pre.next.next;
                index=0;
            }
            pre=cur;
            cur=next;
        }
        return cur.val;
    }
}
