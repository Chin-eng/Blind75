class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = set()
        
        def dfs(room):
            visited.add(room)
            for neighbor in rooms[room]:
                if neighbor not in visited:
                    dfs(neighbor)
        dfs(0)
        return len(rooms) == len(visited)