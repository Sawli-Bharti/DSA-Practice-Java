/*
https://leetcode.com/problems/is-subsequence/
392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 Approach: time complexity O(n) where n is the length of string t, space complexity O(1)
  check all char of t with ith char of s , if they are same then move to next char of s and check with next char of t, if we reach end of s then return true, if we reach end of t and not reach end of s then return false.
*/
public class LC_392_IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        if(n>t.length()) return false;
        if(n==0) return true;
        if(t.length()==0) return false;
        int i=0;
        for(char c:t.toCharArray()){
            if(i<n && c==s.charAt(i)) i++;
        }
        if(i==n) return true;
        return false;
    }
}
