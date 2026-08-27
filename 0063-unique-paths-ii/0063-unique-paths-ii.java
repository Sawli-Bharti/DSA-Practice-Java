class Solution {
    private int solve(int[][] dp, int[][] obstacleGrid, int i, int j){
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        if(i>=m || j>=n || obstacleGrid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=solve(dp,obstacleGrid,i+1,j)+solve(dp,obstacleGrid,i,j+1);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,obstacleGrid,0,0);
    }
}