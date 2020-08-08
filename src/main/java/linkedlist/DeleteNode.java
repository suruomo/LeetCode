package linkedlist;

/**
 * @author suruomo
 * @date 2020/8/8 14:31
 * @description: 237 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 */
public class DeleteNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(5);
        deleteNode(node);
    }

    private static void deleteNode(ListNode node) {
        //让当前结点值为下一个结点值
        node.val=node.next.val;
        //修改指针
        node.next=node.next.next;
    }
}
