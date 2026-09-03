class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int count=1;
        int s=pairs[0][0], e=pairs[0][1];
        for(int i=1;i<n;i++){
            if(e<pairs[i][0]){
                count++;
                e=pairs[i][1];
            }
        }
        return count;
    }
}