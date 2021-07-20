package DataStructure.linearList;

import base.ListNode;

public class LinkedDemo {
    public int getElem(ListNode listNode, int i) {
        int j = 0;
        ListNode head = listNode;
        while (head != null && j < i) {
            head = head.next;
            ++j;
        }
        assert head != null;
        return head.val;
    }

}
