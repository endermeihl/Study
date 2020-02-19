package leetCode;

import base.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode pre=new ListNode(0);
        pre.next=head;
        while(fast!=null){
            ListNode next=fast.next;
            fast.next=null;
            ListNode temp=slow;
            slow.next=null;
            slow=fast;
            slow.next=temp;
            temp.next=next;
            head=slow;
            slow=next;
            fast=slow.next;
        }

        //swap(slow,fast);


        return head;

    }

    public static void main(String[] args){
        SwapPairs swapPairs=new SwapPairs();
        int[] nums=new int[]{1,2,3,4};
        ListNode res=new ListNode(0);
        ListNode pre=res;
        for(int num:nums){
            pre.next= new ListNode(num);
            pre=pre.next;
        }
        swapPairs.swapPairs(res.next);
    }
}
