class Solution {
    
    public boolean checkDivisibility(int n) {
        int num=n;
        int s=0,p=1;
        while(num>0){
            int r=num%10;
            s+=r;
            p*=r;
            num/=10;
        }
        return (n%(s+p)==0)?true:false;
    }
}