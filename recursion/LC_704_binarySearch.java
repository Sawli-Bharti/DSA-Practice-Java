/*

https://leetcode.com/problems/binary-search/
 */

class Solution {
    public int binarySearch(int[] nums, int l, int h, int target){
        if(l>h) return -1;
        int mid=l+(h-l)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target){
            h=mid-1;
        }else{
            l=mid+1;
        }
        return binarySearch(nums,l,h,target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}