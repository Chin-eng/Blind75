# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:

        currentSum = 0
        prefixSum = {0:1}
        self.count = 0

        def dfs(node, currentSum, prefixSum):
            if node: 
                currentSum += node.val
                needed = currentSum - targetSum
                if needed in prefixSum:
                    self.count += prefixSum[needed]
                if currentSum not in prefixSum:
                    prefixSum[currentSum] = 1 
                else:
                    prefixSum[currentSum] += 1
            
                dfs(node.left, currentSum, prefixSum)
                dfs(node.right, currentSum, prefixSum)
                prefixSum[currentSum] -= 1
                currentSum -= node.val
                if prefixSum[currentSum] == 0:
                    del prefixSum[currentSum]
              
        dfs(root, currentSum, prefixSum)
        return self.count
