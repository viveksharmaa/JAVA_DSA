class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        Integer[][] dp = new Integer[n][n];

        return solve(triangle, 0, 0, dp);
    }

    public int solve(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int down = solve(triangle, i + 1, j, dp);

        int right = solve(triangle, i + 1, j + 1, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);

        return dp[i][j];
    }
}