package leetCode;

import base.ListNode;

import java.util.ArrayList;

public class Palindrome {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isPalindrome(ListNode head) {
        ListNode reseveNode = resever(head);
        for (Integer integer : list) {
            if (reseveNode.val != integer) {
                return false;
            }
            reseveNode = reseveNode.next;
        }
        return true;
    }

    private ListNode resever(ListNode head) {
        ListNode res = null;
        ListNode node = head;
        ListNode nextNode;
        while (node != null) {
            list.add(node.val);
            nextNode = node.next;
            node.next = res;
            res = node;
            node = nextNode;
        }
        return res;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        palindrome.isPalindrome(head);
    }
}
