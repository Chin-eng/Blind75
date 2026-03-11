class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:

        adjecency_list = {index:[] for index in range(n)}

        for edges in connections:
            current, neighbor = edges[0], edges[1]
            adjecency_list[current].append((neighbor, 1))
            adjecency_list[neighbor].append((current, 0))


        visited = set()
        self.count = 0
        
        def dfs(node):
            visited.add(node)
            for neighbor, flag in adjecency_list[node]:
                if neighbor not in visited:
                    if flag == 1:
                        self.count += 1
                    dfs(neighbor)
                
                
        for node in range(n):
            dfs(node)

        return self.count
    

