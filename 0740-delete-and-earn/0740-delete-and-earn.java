class Solution {
    public int deleteAndEarn(int[] nums) {
        //  after adding the points problem becomes house robber where we can taker adacent points
        int[] points=new int[2*10000+1];
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            points[nums[i]]+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int dp[]=new int[max+1];
        dp[1]=points[1];
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+points[i]);
        }
        return dp[max];
    }
}