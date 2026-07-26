class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0,j=n-1;
        int max=Integer.MIN_VALUE;
        
         max=Math.max(max,nums[j]*nums[i]*nums[j-1]);
       max=Math.max(max,nums[j]*nums[i]*nums[i+1]);
        return Math.max(max,nums[n-1]*nums[n-2]*nums[n-3]);
    }
}