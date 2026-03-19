/*
    https://leetcode.com/problems/contiguous-array/description/

    problem: find the longest contiguous subarray which contains equal number of 0s and 1s

    Brute force: O(n^2) - check every subarray and count 0s and 1s
    Optimal approach: O(n) - 
    - Replace 0s with -1s, so we need to find the longest subarray with sum 0 
    - if prefix sum is 0 at any index, then we have equal number of 0s and 1s from the start to that index, so update max = i + 1;
    - Use a hashmap to store the first occurrence of each cumulative sum
    - If we see the same cumulative sum again, it means the subarray between the first occurrence and the current index has a sum of 0 (equal number of 0s and 1s)
*/
class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1) return 0;
        int[] zeroPrefixSum=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        int sum=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            zeroPrefixSum[i]=sum;
        }
        for(int i=0;i<n;i++){
            if(zeroPrefixSum[i]==0) max=Math.max(max,i+1);
            else if(map.containsKey(zeroPrefixSum[i])){
                max=Math.max(max,i-map.get(zeroPrefixSum[i]));
            }else{
                map.put(zeroPrefixSum[i],i);
            }
        }
        return max;
    }
}