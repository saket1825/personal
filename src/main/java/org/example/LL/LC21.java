package org.example.LL;

public class LC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode currList1 = list1;
        ListNode currList2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (currList2 != null && currList1 != null) {
            if (currList2.val >= currList1.val) {
                node.next = currList1;
                currList1 = currList1.next;
            } else {
                node.next = currList2;
                currList2 = currList2.next;
            }
            node = node.next;
        }

        if (currList2 != null) {
            node.next = currList2;
        } else {
            node.next = currList1;
        }
        return dummy.next;
    }
}
