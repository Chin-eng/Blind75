class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def backtrack(curr, node):
            curr.append(node)
            if node == len(graph)-1:
                ans.append(list(curr))
            
            for neighbor in graph[node]:
                backtrack(curr, neighbor)
            curr.pop()

        ans = []
        backtrack([], 0)
        return ans
        
        
        