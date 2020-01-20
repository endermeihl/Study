package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Two {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return changeListNode(changeNum(l1)+changeNum(l2));
    }

    private long changeNum(ListNode head){
        int i=0;
        long result=0;
        while(head!=null){
            result+=head.val*Math.pow(10,i);
            head=head.next;
            i++;
        }
        return result;
    }

    private ListNode changeListNode(long num){
        List<Integer> list=new ArrayList<>();
        ListNode head = null;
        if(num==0){
            return new ListNode(0);
        }
        while(num>0){
            list.add((int) (num%10));
            num=num/10;
        }
        for(int i=list.size()-1;i>=0;i--){
            if(head==null){
                head=new ListNode(list.get(i));
            }else {
                ListNode temp=head;
                head=new ListNode(list.get(i));
                head.next=temp;
            }
        }
        return head;
    }

    public static void main(String[] args){
        Two t=new Two();
        System.out.println(t.addTwoNumbers(t.changeListNode(9),t.changeListNode(9999999991L)).val);
    }
}
