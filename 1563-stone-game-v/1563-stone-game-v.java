class Solution {
    int dp[][];
    int prefix[];
    private int solve(int[] stone, int l,int r){
        if(l==r) return 0;
        if(dp[l][r]!=0) return dp[l][r];
        int total=prefix[r+1]-prefix[l];
        int ans=0;
        int leftSum=0;
        for(int i=l;i<r;i++){
            leftSum+=stone[i];
            int rightSum=total-leftSum;
            if(leftSum<rightSum){
                ans=Math.max(ans,leftSum+solve(stone,l,i));
            }else if(leftSum>rightSum){
                ans=Math.max(ans,rightSum+solve(stone,i+1,r));
            }else{
                ans=Math.max(ans,leftSum+Math.max(solve(stone,l,i),solve(stone,i+1,r)));
            }
        }
        return dp[l][r]=ans;
        
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n][n];
        prefix=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+stoneValue[i];
        }
        return solve(stoneValue,0,n-1);
    }
}