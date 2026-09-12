class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int ans  = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            ans = Math.min(ans, solve(matrix, 0, j, dp));
        }
        return ans;
    }
    public int solve(int[][] matrix, int i, int j, int[][] dp){
        int n= matrix.length;
        if(j<0 || j>=n){
            return 100000000;
        }
        if(i==n-1){
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        int left = solve(matrix, i+1, j-1, dp);
        int down = solve(matrix, i+1, j, dp);
        int right = solve(matrix, i+1, j+1, dp);

        dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));

        return dp[i][j];
    }
}