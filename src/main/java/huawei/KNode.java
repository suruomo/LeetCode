package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/23 12:12
 * @description: 返回链表倒数第k个结点
 */
public class KNode {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int nums=sc.nextInt();
            Node head=new Node(-1);
            Node cur=head;
            for (int i = 0; i < nums; i++) {
                cur.next=new Node(Integer.valueOf(sc.next()));
                cur=cur.next;
            }
            int k=sc.nextInt();
            System.out.println(getValue(head,k,nums));
        }
    }

    private static int getValue(Node head, int k,int nums) {
        if(k==0){
            return 0;
        }
        if (k<0){
            return 0;
        }
        k=nums-k+1;
        Node cur=head;
        while (k!=0){
            cur=cur.next;
            k--;
        }
        return cur.value;
    }
}
