/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

28. Find the Index of the First Occurrence in a String

Approach Sliding windpw approach
Time complexity O(m*n) where m is the length of haystack and n is the length of needle

 */

 class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        int m=haystack.length();
        if(m<n) return -1;
        int i=0,j=n-1;
        while(j<m){
            boolean found=true;
            for(int k=i;k<=j;k++){
               if(needle.charAt(k-i)!=haystack.charAt(k)){
                found=false;
                break;
               }
            }
            if(found) return i;
            i++;
            j++;
            
        }
        return -1;
    }
}