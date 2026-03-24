/*
    https://leetcode.com/problems/product-of-array-except-self/
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    naive approach: for each element, calculate the product of all other elements. This would take O(n^2) time.
     notes-> if the array doesn't contain 0, we can calculate the total product of all elements and then divide by each element to get the result. This would take O(n) time but division is not allowed in this problem.
    optimal approach: we can use two arrays, left and right, to store the product of all elements to the left and right of each element respectively. Then we can multiply the corresponding elements of left and right to get the final result. This would take O(n) time and O(n) space.
     
*/

public class LC_238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int p=1;
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            left[i]=p;
            p*=nums[i];
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            right[i]=p;
            p*=nums[i];
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
}
