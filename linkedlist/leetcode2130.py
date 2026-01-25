# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head
        slowPrev = None

        while fast:
            slowPrev = slow
            slow = slow.next
            fast = fast.next.next
        
        Curr = slow
        Prev = None
        Next = None
        
        while Curr:
            Next = Curr.next
            Curr.next = Prev
            Prev = Curr
            Curr = Next
        
        slowPrev.next = Prev

        maxVal = float("-inf")
        while Prev:
            maxVal  = max(maxVal, head.val + Prev.val)
            Prev = Prev.next
            head = head.next
        
        return maxVal
        


        