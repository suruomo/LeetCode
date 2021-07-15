package linkedlist;

import java.util.ArrayList;

/**
 * @Author: suruomo
 * @Date: 2021/7/15 15:19
 * @Description: 合并 k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 */
public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return merge(lists,0,lists.size()-1);
    }

    /**
     * 分治
     * @param lists
     * @param l
     * @param r
     * @return
     */
    private ListNode merge(ArrayList<ListNode> lists, int l, int r) {
        // 已经归并结束
        if (l==r){
            return lists.get(0);
        }
        if (l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    /**
     * 合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        cur=list1==null?list2:list1;
        return head.next;
    }
}
