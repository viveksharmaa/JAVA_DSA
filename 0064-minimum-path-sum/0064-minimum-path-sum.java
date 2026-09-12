class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve (grid, 0, 0, dp);
    }
    public int solve(int[][] grid, int i, int j, int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m || j>=n){
            return 1000000000;
        }

        if(i>=m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(grid, i+1, j, dp);
        int right = solve(grid, i, j+1, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }
}