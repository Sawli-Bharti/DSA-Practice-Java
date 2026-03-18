       
    //    https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/?envType=daily-question&envId=2026-03-16

//     Step-by-step:

// Loop over every cell (i, j) → treat as center

// Add single cell (size 0 rhombus)

// Expand radius k = 1, 2, ...

// Stop if out of bounds

// For each valid rhombus:

// Traverse 4 edges properly

// Store in set (unique values)

// Extract top 3 largest

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                set.add(grid[i][j]);
                int k=1;
                while(true){
                    if(i-k<0 || i+k>=n || j-k<0 || j+k>=m){
                        break;
                    }
                    int tempSum=0;
                    for(int d=0;d<k;d++){
                        tempSum += grid[i - k + d][j + d]; // top-right
                        tempSum += grid[i + d][j + k - d]; // right-bottom
                        tempSum += grid[i + k - d][j - d]; // bottom-left
                        tempSum += grid[i - d][j - k + d]; // left-top
                    }
                    set.add(tempSum);
                    k++;
                }
            }
        }
        
        int size = Math.min(3, set.size());
        int[] res = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            res[i] = set.pollLast();
        }
        int i=0,j=res.length-1;
        while(i<j){
            int temp=res[i];
            res[i]=res[j];
            res[j]=temp;
            i++;
            j--;
        }
        return res;

    }
}