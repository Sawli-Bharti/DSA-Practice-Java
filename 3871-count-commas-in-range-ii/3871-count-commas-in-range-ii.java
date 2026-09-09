class Solution {
    int count=0;
    public long solve(long n, long a){
        if(a>n) return 0L;

        return n-a+1+solve(n,a*1000);
    }
    public long countCommas(long n) {
        return solve(n,1000);
    }
}