class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:

        adjecency_list = {i:[] for i in range(len(isConnected))}
        
        for node in range(len(isConnected)):
            neighbors = isConnected[node]
            for neighbor in range(len(neighbors)):
                if node != neighbor and neighbors[neighbor] == 1:
                    adjecency_list[node].append(neighbor)
        
        visited = set()
        count = 0

        print(adjecency_list)
        
        def dfs(node):
            visited.add(node)
            for neighbor in adjecency_list[node]:
                if neighbor not in visited:
                    dfs(neighbor)


        for node in range(len(adjecency_list)):
            if node not in visited:
                dfs(node)
                count += 1
                
        return count