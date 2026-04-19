/*
https://leetcode.com/problems/sort-an-array/description/

 */

 class Solution {
    public void mergeSort(int[] nums, int l, int h, int mid){
        int[] temp=new int[h-l+1];
        int left=l,right=mid+1;
        int i=0;
        while(left<=mid && right<=h){
            if(nums[left]<=nums[right]){
                temp[i]=nums[left];
                left++;
            }else{
                temp[i]=nums[right];
                right++;
            }
            i++;
        }
        while(left<=mid){
            temp[i]=nums[left];
            left++;
            i++;
        }
        while(right<=h){
            temp[i]=nums[right];
            right++;
            i++;
        }
        for(int j=0;j<temp.length;j++){
            nums[l+j]=temp[j];
        }
    }
    public void merge(int[] nums, int l, int h){
        if(l>=h) return;
        int mid=l+(h-l)/2;
        merge(nums,l,mid);
        merge(nums,mid+1,h);
        mergeSort(nums,l,h,mid);
    }
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
}