class Solution {
    private int recursion(int[] cost, int dp[],int i){
        int n=cost.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=cost[i]+Math.min(recursion(cost,dp,i+1),recursion(cost,dp,i+2));
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
       return Math.min(recursion(cost,dp,0),recursion(cost,dp,1));
    }
}