# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def dfs(node, p, q) -> 'TreeNode':
            if not node:
                return None 
            
            left = dfs(node.left, p, q)
            right = dfs(node.right, p, q)

            if node == p or node == q:
                return node

            if not left and not right:
                return None

            if left and right:
                return node
            
            if right:
                return right
            
            return left


        return dfs(root, p, q)