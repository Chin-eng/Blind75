class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:

        directions = [(0,1), (1, 0), (-1, 0), (0, -1)]

        def inRange(row, column) -> bool:
            # print(row < len(maze))
            return 0 <= row < len(maze) and 0 <= column < len(maze[0])

        def onBorder(row, column) -> bool:
            return (row == 0 or column == 0) or (row == len(maze)-1 or column == len(maze[0])-1)
        
        visited = set()
        visited.add((entrance[0], entrance[1]))

        queue = deque()
        queue.append((entrance[0], entrance[1], 0))
        # print(queue)

        while len(queue) > 0: 
            for _ in range(len(queue)):
                row, col, step = queue.popleft()
                print(row, col, step)
                
                if onBorder(row, col) and maze[row][col] == "." and not (row == entrance[0] and col == entrance[1]):
                    return step
                
                for dx, dy in directions:
                    d_row, d_col = row + dy, col + dx
                    # print(d_row, d_col)
                    if inRange(d_row, d_col) and (maze[d_row][d_col] == ".") and ((d_row, d_col) not in visited):
                        queue.append((d_row, d_col, step + 1))
                        # print(queue)
                        visited.add((d_row, d_col))

        return -1

        