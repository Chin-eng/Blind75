# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        
        if not root:
            return -1

        queue = []
        queue.append(root)
        my_map = []
        level = 1

        while queue:
            queue_length = len(queue)
            temp = []
            for _ in range(queue_length):
                node = queue.pop(0)
                temp.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            my_map.append(sum(temp))
            level += 1
            
        maxVal = float("-inf")
        for val in my_map:
            maxVal = max(maxVal, val)
        return my_map.index(maxVal) + 1