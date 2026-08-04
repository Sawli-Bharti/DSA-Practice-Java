class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        List<Integer> ans=new ArrayList<>();
        while(i<n){
            int a=nums[i];
            while(i+1<n && a+1!=nums[i+1]){
                a++;
                ans.add(a);
            }
            i++;
        }
        return ans;
    }
}