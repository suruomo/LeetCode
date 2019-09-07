package array;

/**
 * 问题：Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *思路：设置一个preHead节点简化操作,preHead next 指向head。
 *
 * 初始化first为第一个节点
 * 初始化second为第二个节点
 * 初始化current为preHead
 * first.next = second.next
 * second.next = first
 * current.next = second
 * current 移动两格
 * 重复
 *
 *
 */
public class SwapNodesInParis {
    static class ListNode{        //节点类
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            val=x;
        }
    }
    ListNode swap(ListNode head){
        ListNode preHead=new ListNode();
        preHead.next=head;
        ListNode current=preHead;
        while(current.next!=null&&current.next.next!=null){
          ListNode first=current.next;
          ListNode second=current.next.next;
          first.next=second.next;
          second.next=first;
          current.next=second;
          current=current.next.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
       ListNode head=new ListNode(1);
       ListNode cur=head;
       for(int i=0;i<5;i++){
            ListNode q=new ListNode(i);
            cur.next=q;
            cur=cur.next;
        }
       SwapNodesInParis swapNodesInParis=new SwapNodesInParis();
       head=swapNodesInParis.swap(head);
        while(head!=null){
            System.out.print(head.val+"--");
            head=head.next;
        }
    }
}
