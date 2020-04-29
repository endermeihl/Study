package leetCode.bak;

import base.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode dump=res;
        int temp=0;
        int target=0;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                target=(temp+l1.val+l2.val)%10;
                temp=(temp+l1.val+l2.val)/10;
            }else if(l1==null && l2!=null){
                target=l2.val+temp;
                temp=target/10;
            }else{
                target=l1.val+temp;
                temp=target/10;
            }
            res.next=new ListNode(target);
            res=res.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }

        }
        if(temp!=0){
            res.next=new ListNode(temp);
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }
}
