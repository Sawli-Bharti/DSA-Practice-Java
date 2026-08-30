class Solution {
    private int solve(int[][] grid, int [][] dp, int m,int n, int i, int j){
        if(i>=m || j>=n) return 100000;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(solve(grid,dp,m,n,i+1,j),solve(grid,dp,m,n,i,j+1));

        
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        dp[m-1][n-1]=grid[m-1][n-1];

        return solve(grid,dp,grid.length,grid[0].length,0,0);
        
    }
}