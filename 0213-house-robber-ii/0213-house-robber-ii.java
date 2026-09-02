class Solution {
    private int solve(int[] dp, int[] nums, int i,int bound){
        int n=nums.length;
        if(i>=bound) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int skip=solve(dp,nums,i+1,bound);
        int rob=solve(dp,nums,i+2,bound)+nums[i];
        
        return dp[i]=Math.max(skip,rob);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int [n];
        Arrays.fill(dp1,-1);
        int[] dp2=new int [n];
        Arrays.fill(dp2,-1);
        return Math.max(solve(dp1,nums,0,n-1),solve(dp2,nums,1,n));
    }
}