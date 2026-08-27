class Solution {
    private int solve(int[][] dp,int i, int j){
        if(i>=dp.length || j>=dp[0].length) return 0;
        if(i==dp.length-1 && j==dp[0].length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=solve(dp,i+1,j)+solve(dp,i,j+1);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,0,0);
        
    }
}