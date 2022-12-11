from typing import List

# Time Complexity: O(M×N). where M is length of rows and N is length of cols
# Space Complexity: O(1). not using any extra space


def uniquePathsWithObstacles(obstacleGrid: List[List[int]]) -> int:
    rows = len(obstacleGrid)
    cols = len(obstacleGrid[0])

    if obstacleGrid[0][0] == 1:
        return 0

    obstacleGrid[0][0] = 1

    for i in range(1, rows):
        obstacleGrid[i][0] = int(obstacleGrid[i][0] == 0 and obstacleGrid[i - 1][0] == 1)

    for j in range(1, cols):
        obstacleGrid[0][j] = int(obstacleGrid[0][j] == 0 and obstacleGrid[0][j - 1] == 1)

    for i in range(1, rows):
        for j in range(1, cols):
            if obstacleGrid[i][j] == 0:
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
            else:
                obstacleGrid[i][j] = 0

    return obstacleGrid[rows - 1][cols - 1]


if __name__ == "__main__":
    obstacleGrid = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
    print(uniquePathsWithObstacles(obstacleGrid))
