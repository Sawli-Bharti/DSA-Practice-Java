class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=-1;
        if(n==k || k==1){
            for(int i=0;i<n;i++){
            if(map.get(nums[i])==1) ans=Math.max(ans,nums[i]);
            }
            return ans;
        }
        
       if(map.get(nums[0])>1 && map.get(nums[n-1])>1) return -1;
       if(map.get(nums[0])>1) return nums[n-1];
       if(map.get(nums[n-1])>1) return nums[0];
        return Math.max(nums[0],nums[n-1]);

    }
}