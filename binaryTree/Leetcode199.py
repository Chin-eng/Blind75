# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if not root:
            return []

        queue = []
        res = []

        queue.append(root)

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
            
            res.append(temp[-1])
        
        return res
        
