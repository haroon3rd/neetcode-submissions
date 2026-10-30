class Solution {

    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {

        // perimeter edge (outside ixj)
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
       

        // perimeter edge (water)
        if (grid[i][j] == 0){
            return 1;
        }
            

        // Already visited box
        if(grid[i][j] == 2){
            return 0;
        }
            

        // Mark land as visited
        grid[i][j] = 2;

        // Recursively explore four directions
        return dfs(grid, i - 1, j) +
               dfs(grid, i + 1, j) +
               dfs(grid, i, j - 1) +
               dfs(grid, i, j + 1);
    }
}