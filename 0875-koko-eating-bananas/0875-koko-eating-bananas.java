class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l=1, h=piles[0];
        int n=piles.length;
        for(int a:piles){
            
            h=Math.max(h,a);
        }
        int k=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            long totalH=0;
            for(int a:piles){
                totalH+=a/mid;
                if(a%mid>0) totalH++;
            }
            if(totalH<=H){
                k=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return k;
    }
}