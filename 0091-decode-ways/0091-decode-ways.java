class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }
    public int solve(String s, int index, int[] dp){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int ways = solve(s, index+1, dp);

        if(index + 1 < s.length()){
            int num = Integer.parseInt(s.substring(index, index + 2));
            if(num>=10 && num<=26){
                ways += solve(s, index+2, dp);
            }
        }
        dp[index] = ways;
        return ways;
    }
}