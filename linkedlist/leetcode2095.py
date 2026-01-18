# Definition for singly-linked list. 
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Brute force
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        Curr = head
        Prev = None 

        count = 0
        while (Curr != None):
            count +=1
            Curr = Curr.next

        if count == 1:
            return None

        mid = count//2
        n = 0
        Curr = head
        while n < mid:
            n+=1
            Prev = Curr
            Curr = Curr.next

        if Prev:
            Prev.next = Curr.next

        return head
    
