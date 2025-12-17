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
    // iterative approach
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

//optimal solution
    public ListNode reverseListOptimal(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    // recursive approach
    public ListNode reverseListrecursive(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();
        traverse(head, arrayList);
        List<Integer> reversed_arrayList = reverse(arrayList);
        ListNode newHead = null;
        ListNode current = null; 
        return createList(reversed_arrayList, 0); 
    }

    private void traverse(ListNode head, List arrayList) {
        if (head == null) return;
        arrayList.add(head.val); 
        traverse(head.next, arrayList);
    }

    private List<Integer> reverse(List<Integer> arrayList) {
        List<Integer> reverseList = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            reverseList.add(arrayList.get(i));
        }
        return reverseList;
    }

    private ListNode createList(List<Integer> arrayList, int index) {
        if (index == arrayList.size()) {
            return null; 
        }

        ListNode node = new ListNode(arrayList.get(index));
        node.next = createList(arrayList, index + 1);
        return node;
    }


public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}
