class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int x=nums[0];
        int s=0;
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
           x=x^nums[i];
             
        }
        boolean nonZero=false;
        for(int a:nums){
            if(a>0){
                nonZero=true;
                break;
            }
        }
        if(x==0 && nonZero) return n-1;
        if(x==0 && !nonZero) return 0;
        return n;
    }
}