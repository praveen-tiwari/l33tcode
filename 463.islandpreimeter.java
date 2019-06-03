/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int up = i-1;
                    int down = i+1;
                    int left = j-1;
                    int right = j+1;
                    if (up < 0)
                        perimeter += 1;
                    if (left < 0)
                        perimeter += 1;
                    if (down == grid.length)
                        perimeter += 1;
                    if (right == grid[i].length)
                        perimeter += 1;
                    if (up >= 0 && grid[up][j] == 0)
                        perimeter += 1;
                    if (down < grid.length && grid[down][j] == 0)
                        perimeter += 1;
                    if (left >= 0 && grid[i][left] == 0)
                        perimeter += 1;
                    if (right < grid[i].length && grid[i][right] == 0)
                        perimeter += 1;
                }
            }
        }
        return perimeter;
    }
}
