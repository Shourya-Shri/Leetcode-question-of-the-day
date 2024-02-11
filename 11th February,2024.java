/*You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.*/

class Solution {
    
    Integer memo[][][];
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new Integer[rows+1][cols+1][cols+1];
        return helper(grid, 0, 0, cols-1);
    }
    
    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {
        
        if(robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) return 0;
        
        if(currRow == grid.length) return 0;
        
        if(memo[currRow][robotACol][robotBCol] != null)
            return memo[currRow][robotACol][robotBCol];
        
        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];
        
        int max = 0;
        for(int x=robotACol-1;x<=robotACol+1;x++) {
            for(int y=robotBCol-1;y<=robotBCol+1;y++) {
                if(x < y) { // they should not cross
                    max = Math.max(max, helper(grid, currRow+1, x, y));
                }
            }
        }
        
        result += max;
        return memo[currRow][robotACol][robotBCol] = result;
    }
}
