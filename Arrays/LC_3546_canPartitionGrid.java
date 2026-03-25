/*
    https://leetcode.com/problems/equal-sum-grid-partition-i/?envType=daily-question&envId=2026-03-25

    You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

    ->Each of the two resulting sections formed by the cut is non-empty.
    ->The sum of the elements in both sections is equal.

    Return true if such a partition exists; otherwise return false.

    Approach:
    Brute force check every horizontal and verticle partitions
*/


class Solution {
    public long sum(int[][] grid ,int n, int m){
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
            }
        }
        return sum;
    }
    public boolean canPartitionGrid(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        long sum=sum(grid,n,m);
        long h=0;
        for(int i=0;i<n;i++){
            
            
            //horizontal
            for(int j=0;j<m;j++){
                h+=grid[i][j];
            }
            if(h==sum-h) return true; 
        }
        long v=0;
        for(int i=0;i<m;i++){
            
            // vertical
            for(int j=0;j<n;j++){
                v+=grid[j][i];
            }
            if(v==sum-v) return true;
        }
        return false;
    }
}