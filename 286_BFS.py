"""
286. Walls and Gates

You are given a m x n 2D grid initialized with these three possible values.

-1  - A wall or an obstacle. 
0   - A gate. 
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF 
	  as you may assume that the distance to a gate is less than 2147483647. 

Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

Example:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After change:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

Solution:
I will use the thought of BreadFirstSearch
Maintain a queue, first input will be first taken out and moved forward

"""

def wallsAndGates(grid):
	queue = []

	ROWS, COLS = len(grid), len(grid[0])

	# Loop through and find all the gates which are the starting points and push into queue
	# By taking out the first element from the queue, it will guarantee that all the empty space will be set with
	# the smallest value from the closest gate

	for i in range(ROWS):
		for j in range(COLS):
			if grid[i][j] == 0:
				queue.append((i, j))

	directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
	
	while queue:
		r, c = queue.pop(0)

		for direction in directions:

			newr = r + direction[0]
			newc = c + direction[1]

			if newr < 0 or newc < 0 or newr == ROWS or newc == COLS:
				continue
		
			if grid[newr][newc] != 2 ** 31 - 1:  # Which means that it either has been set a value or it is a wall
				continue

			grid[newr][newc] = grid[r][c] + 1
			queue.append((newr, newc))







