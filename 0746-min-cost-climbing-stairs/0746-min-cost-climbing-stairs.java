class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=cost[i]+Math.min((i+1>=n)?0:dp[i+1],(i+2>=n)?0:dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}