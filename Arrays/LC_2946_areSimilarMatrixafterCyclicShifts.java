/*
    https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/?envType=daily-question&envId=2026-03-27

    2946. Are Similar Matrix after Cyclic Shifts
*/

// brute froce

class Solution {
    public void leftShift(int[][] mat,int m, int i){
        int el=mat[i][0];
        int j=1;
        while(j<m){
            mat[i][j-1]=mat[i][j];
            j++;
        }
        mat[i][m-1]=el;
    }
    public void rightShift(int[][] mat,int m, int i){
        int el=mat[i][m-1];
        int j=m-2;
        while(j>=0){
            mat[i][j+1]=mat[i][j];
            j--;
        }
        mat[i][0]=el;
    }
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k=k%m;
        int[][] temp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=mat[i][j];
            }
        }
        while(k>0){
            for(int i=0;i<n;i++){
                if(i%2==0){
                    leftShift(mat,m,i);
                }
                else{
                    rightShift(mat,m,i);
                }
            }
        k--;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(temp[i][j]!=mat[i][j]) return false;
            }
        }
        return true;
        
    }
}


// optimal
class Solution {
    
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=mat[i][(j+k)%m]) return false;
            }
        }
        return true;
        
    }
}