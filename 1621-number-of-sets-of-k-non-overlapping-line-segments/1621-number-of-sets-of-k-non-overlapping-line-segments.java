class Solution {
    private long MOD=1000000007;
    private long factorial(int n){
        if(n==1 || n==0) return 1;
        return ((n%MOD)*(factorial(n-1)%MOD))%MOD;
    }
     private long power(long a, long b) {
        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b = b / 2;
        }

        return result;
    }
    public int numberOfSets(int n, int k) {
        int N=n+k-1, R=2*k;
         long numerator = factorial(N);

        long denominator =
                (factorial(R) * factorial(N - R)) % MOD;

        long inverse = power(denominator, MOD - 2);

        long ans = (numerator * inverse) % MOD;
        return (int)ans;
    }
}