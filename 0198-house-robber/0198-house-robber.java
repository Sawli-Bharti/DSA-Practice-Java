class Solution {
    private int solve(int[] dp, int [] nums, int i){
        if(i>=nums.length) return 0;
        if(i==nums.length-1) return nums[i];
        if(dp[i]!=-1) return dp[i];
        int skip=solve(dp,nums,i+1);
        int keep=solve(dp,nums,i+2)+nums[i];
        return dp[i]=Math.max(skip,keep);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(dp,nums,0);
    }
}