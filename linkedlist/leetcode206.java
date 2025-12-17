package linkedlist;

import java.util.ArrayList;
import java.util.List;

// 206. Reverse Linked List
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the head of a singly linked list, reverse the list, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000


public class leetcode206 {
    public ListNode reverseList(ListNode head) {
    if (head == null) {
        return head;
    }

    List<Integer> arrayList = new ArrayList<>();

    while (head != null) {
        arrayList.add(head.val);
        head = head.next;
    }

    // System.out.println(arrayList);
    ListNode newHead = null;
    ListNode current = null;
    for (int i = arrayList.size()-1; i >= 0; i--) {
        ListNode newNode = new ListNode(arrayList.get(i));
        // System.out.println(newNode.val);
        if (newHead == null) {
            newHead = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            current = newNode;
        }
    }

    return newHead;
}


public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}
