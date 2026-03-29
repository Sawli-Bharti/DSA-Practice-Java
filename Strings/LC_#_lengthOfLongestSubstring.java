/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

    3. Longest Substring Without Repeating Characters

    approach: brute force
    TC:- O(n^2)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int n=s.length();
        if(n==0 || n==1) return n;
        for(int i=0;i<n;i++){
            Set<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            for(int j=i+1;j<n;j++){
                if(set.contains(s.charAt(j))){
                    ans=Math.max(ans,j-i);
                    break;
                }else
                {
                    set.add(s.charAt(j));
                    if(j==n-1) ans=Math.max(ans,j-i+1);
                } 
            }
        }
        return ans;
    }
}