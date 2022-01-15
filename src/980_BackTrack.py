class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        """
            Try DFS
            First iterate all the positions to set all visited value of the
            obstacles to True
            Implement DFS(start position)
            Return the maintained value
        """
        
        ROWS, COLS = len(grid), len(grid[0])
        res = [0]
        
        visited = [[False for _ in range(COLS)] for _ in range(ROWS)]
        start = (0,0)
        left = ROWS * COLS
        
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == 1:
                    start = (i, j)
                if grid[i][j] == -1:
                    visited[i][j] = True
                    left -= 1
        
        def DFS(r, c, left):
            if r < 0 or c < 0 or r == ROWS or c == COLS:
                return
            
            if visited[r][c]:
                return
            
            if grid[r][c] == 2:
                if left == 1:
                    res[0] = res[0] + 1
                else:
                    return
            
            visited[r][c] = True
            DFS(r + 1, c, left - 1)
            DFS(r - 1, c, left - 1)
            DFS(r, c + 1, left - 1)
            DFS(r, c - 1, left - 1)
            visited[r][c] = False
            
            return
        
        DFS(start[0], start[1], left)
        
        return res[0]
        
        
        
        
        
#         ROWS, COLS = len(grid), len(grid[0])
        
#         visited = [[True if grid[i][j] == -1 else False for j in range(COLS)] for i in range(ROWS)]
#         res = [0]
        
#         def DFS(r, c, left):
#             if r < 0 or c < 0 or r == ROWS or c == COLS:
#                 return
            
#             if visited[r][c]:
#                 return
            
#             if grid[r][c] == 2:
#                 if left == 1:
#                     res[0] = res[0] + 1
#                     return
#                 else:
#                     return
            
#             if grid[r][c] == 0:
#                 visited[r][c] = True
#                 DFS(r + 1, c, left - 1)
#                 DFS(r - 1, c, left - 1)
#                 DFS(r, c + 1, left - 1)
#                 DFS(r, c - 1, left - 1)
#                 visited[r][c] = False
#                 return
            
#             if grid[r][c] == 1:
#                 visited[r][c] = True
#                 DFS(r + 1, c, left - 1)
#                 DFS(r - 1, c, left - 1)
#                 DFS(r, c + 1, left - 1)
#                 DFS(r, c - 1, left - 1)
#                 return
        
#         start = (0,0)
#         left = ROWS * COLS
#         for i in range(ROWS):
#             for j in range(COLS):
#                 if grid[i][j] == 1:
#                     start = (i,j)
#                 if grid[i][j] == -1:
#                     left -= 1
#         DFS(start[0], start[1], left)
        
#         return res[0]
            
            
                
                