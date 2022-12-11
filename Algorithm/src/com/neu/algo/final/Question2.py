from typing import List

# Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
# Space complexity : O(1) not using any extra space


def numOfIslands(grid: List[List[str]]) -> int:
    rowLength = len(grid)
    if rowLength == 0:
        return None
    colLength = len(grid[0])
    maxIsland = 0

    for i in range(rowLength):
        for j in range(colLength):
            if grid[i][j] == '1':
                maxIsland += 1
                visitNeighbours(grid, i, j, rowLength, colLength)

    return maxIsland


def visitNeighbours(grid, x, y, row, col):
    if x < 0 or x >= row or y < 0 or y >= col or grid[x][y] != '1':
        return

    grid[x][y] = '2'

    visitNeighbours(grid, x + 1, y, row, col)
    visitNeighbours(grid, x, y + 1, row, col)
    visitNeighbours(grid, x - 1, y, row, col)
    visitNeighbours(grid, x, y - 1, row, col)


if __name__ == '__main__':
    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]

    print(numOfIslands(grid))