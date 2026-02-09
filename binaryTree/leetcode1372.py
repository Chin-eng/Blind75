# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.length = float("-inf")

        def dfs(node, direction, depth):
            if node: 
                self.length = max(self.length, depth)
                if direction == "left":
                    dfs(node.left, "right", depth + 1)
                    dfs(node.right, "left", 1)
                else:
                    dfs(node.right, "left", depth + 1)
                    dfs(node.left, "right", 1)        

        dfs(root, "left", 0)
        dfs(root, "right", 0)
        return self.length