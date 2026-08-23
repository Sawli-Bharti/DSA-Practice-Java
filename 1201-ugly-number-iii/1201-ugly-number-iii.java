class Solution {
    private long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    private long lcm(long a, long b){
        return a/gcd(a,b)*b;
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low=1;
        long high=2000000000L;
        long lab=lcm(a,b);
        long lac=lcm(a,c);
        long lbc=lcm(b,c);
        long labc=lcm(lcm(a,b),c);
        while(low<high){
            long mid=low+(high-low)/2;
            long ugly=(mid/a)+(mid/b)+(mid/c)-mid/lab-mid/lac-mid/lbc+mid/labc;
            if(ugly<n)low=mid+1;
            else high=mid;
        }
        return (int)low;
    }
}