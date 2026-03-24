/*
    https://leetcode.com/problems/construct-product-matrix/?envType=daily-question&envId=2026-03-24

    Problem: Construct Product Matrix (LeetCode)

Given a matrix grid (n × m), return a matrix ans where:

ans[i][j] = product of all elements in grid except grid[i][j] % 1234

🚀 Approach (Prefix + Suffix)
Traverse matrix in row-major order.
Build:
left[i][j] → product of all elements before (i,j)
right[i][j] → product of all elements after (i,j)
Final answer:
ans[i][j] = (left[i][j] * right[i][j]) % 12345
❌ Why Not Use Division?
If any element is 0, division breaks (undefined).
With modulo (12345), division is not valid unless modular inverse exists.
Modular inverse doesn’t always exist (since 12345 is not prime).

👉 Hence, prefix–suffix avoids all these issues.

⏱️ Complexity
Time: O(n × m)
Space: O(n × m)
*/
public class LC_2906_constructProductMatrix {
    public void prefixProduct(long[][] left,int[][] grid){
        long p=1;
        for(int i=0;i<left.length;i++){
            for(int j=0;j<left[0].length;j++){
                left[i][j]=p;
                p=(p*grid[i][j])%12345;
            }
        }
    }
    public void sufixProduct(long[][] right,int[][] grid){
        long p=1;
        for(int i=right.length-1;i>=0;i--){
            for(int j=right[0].length-1;j>=0;j--){
                right[i][j]=p;
                p=(p*grid[i][j])%12345;
            }
        }
    }
    public int[][] constructProductMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        long[][] left=new long[n][m];
        long[][] right=new long[n][m];
        prefixProduct(left,grid);
        sufixProduct(right,grid);
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=(int)((left[i][j]*right[i][j])%12345);
            }
        }
        return ans;
    }
}
