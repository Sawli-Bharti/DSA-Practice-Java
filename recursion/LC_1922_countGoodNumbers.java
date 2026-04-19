/*
https://leetcode.com/problems/count-good-numbers/
 */

 /*
 
 approach:- we can solve this problem using fast exponentiation (binary exponentiation). we can calculate the power of 5 for the even positions and the power of 4 for the odd positions, then multiply them together.
 */

 class Solution {
    public long MOD=1000000007;
    public long fastPow(int x, long n){
        if(n==0) return 1;
        long half=fastPow(x,n/2);
        if(n%2==0) return (half*half)%MOD;
        else return (x*half*half)%MOD;
    }
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        return (int)((fastPow(5,even)*fastPow(4,odd))%MOD);
    }
}