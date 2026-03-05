# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:

        if not root:
            return None

        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        else:
            if not root.left and not root.right:
                return None
            elif not root.right and root.left:
                return root.left
            elif not root.left and root.right:
                return root.right
            else:
                node = self.rightSubTreeMin(root.right)
                if node:
                    root.val = node.val
                    root.right = self.deleteNode(root.right, node.val)
                    return root

        return root


    def rightSubTreeMin(self, node: Optional[TreeNode]) -> Optional[TreeNode]:

        if not node:
            return None

        if not node.left and not node.right:
            return node

        if not node.left and node.right:
            return node

        minNode = self.rightSubTreeMin(node.left)

        return minNode





        