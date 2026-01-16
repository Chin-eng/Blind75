# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
            Curr = head
            Prev = None
            Next = None

            while (Curr != None):
                Next = Curr.next
                Curr.next = Prev
                Prev = Curr
                Curr = Next

            return Prev