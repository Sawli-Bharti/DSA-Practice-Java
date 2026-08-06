class Solution {
    private int digitProduct(int n){
        int p=1;
        while(n>0){
            int r=n%10;
            p*=r;
            n/=10;
        }
        return p;

    }
    public int smallestNumber(int n, int t) {

        int p=digitProduct(n);
        while(p%t!=0){
            n++;
            p=digitProduct(n);
        }
        return n;

    }
}