package leetCode;

import base.ListNode;

public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node=root;
        int i=0;
        while(node!=null){
            node=node.next;
            i++;

        }
        node=root;
        int count=i/k;
        int charge=i%k;
        ListNode[] res=new ListNode[k];
        for(int j=0;j<k;j++){
            ListNode head=new ListNode(0);
            ListNode write=head;
            for(int m=0;m<count+(j<charge?1:0);m++){
                write.next=new ListNode(node.val);
                write=write.next;
                if(node!=null){
                    node=node.next;
                }
            }
            res[i]=head.next;
        }
        return res;
    }

    public static void main(String[] args){
        SplitListToParts splitListToParts=new SplitListToParts();
        int[] nums=new int[]{1,2,3,4};
        ListNode head=new ListNode(0);
        ListNode node=head;
        for(int i=0;i<nums.length;i++){
            node.next=new ListNode(nums[i]);
            node=node.next;
        }
        splitListToParts.splitListToParts(head.next,5);
    }
}
