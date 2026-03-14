class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        answer = []

        adjecency_list = defaultdict(list)

        index = 0
        for nodes in equations:
            start, end = nodes[0], nodes[1]
            value = values[index]
            adjecency_list[start].append((end, value))
            adjecency_list[end].append((start, 1/value))
            index += 1

        print(adjecency_list)

        visited = set()
       
        def dfs(start, end) -> int:
            
            if start == end:
                return 1
            
            visited.add(start)
            
            for neighbor, weight in adjecency_list[start]:
                if neighbor not in visited:   
                    result = dfs(neighbor, end)         
                    if result != -1:
                        return weight *result
            
            return -1
                              
        
        for query in queries:
            start, end = query[0], query[1]
            if (start not in adjecency_list) or (end not in adjecency_list):
                answer.append(-1)
            elif start == end:
                answer.append(1)
            else:
                weight = dfs(start, end)
                answer.append(weight)
                visited.clear()

        return answer

        