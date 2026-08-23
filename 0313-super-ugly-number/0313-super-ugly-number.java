class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ans=new long[n];
        ans[0]=1;
        int[] idx=new int[primes.length];
        for(int i=1;i<n;i++){
            long min=Long.MAX_VALUE;
            for(int p=0;p<primes.length;p++){
                min=Math.min(min,ans[idx[p]]*primes[p]);
            }
            ans[i]=min;
            for(int p=0;p<primes.length;p++){
                if(primes[p]*ans[idx[p]]==min) idx[p]++;
            }
        }
        return (int)ans[n-1];
    }
}