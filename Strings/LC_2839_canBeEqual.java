/*

https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/?envType=daily-question&envId=2026-03-29

You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.

 approach: brute force
 TC:- O(1)
 */

 class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.charAt(0)==s2.charAt(0) || s1.charAt(0)==s2.charAt(2)){
            if(s1.charAt(1)==s2.charAt(1) || s1.charAt(1)==s2.charAt(3)){
                if(s1.charAt(3)==s2.charAt(3) || s1.charAt(3)==s2.charAt(1)){
                    if(s1.charAt(2)==s2.charAt(2) || s1.charAt(2)==s2.charAt(0)){
                        return true;
                    }else return false;
                }else return false;
                

            }else return false;
        }else return false;
    }
}