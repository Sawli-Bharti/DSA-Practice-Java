class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        long[] dp=new long[n];
        long[] last=new long[26];
        dp[0]=2;
        last[s.charAt(0)-'a']=1;
        long mod=1_000_000_007L;
        for(int i=1;i<n;i++){
            dp[i]=(2*dp[i-1]-last[s.charAt(i)-'a']+mod)%mod;
            last[s.charAt(i)-'a']=dp[i-1];
        }
        return (int)((dp[n-1]-1+mod)%mod);

    }
}