/*
    https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

    1456. Maximum Number of Vowels in a Substring of Given Length

    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

approach: sliding window->take window size of k and count vowels in that in more efficient when window j++ then if i has vowl then count-- and if j has vowl then count++ and keep track of max count

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int maxVowels(String s, int k) {
       
        int count=0;
        int ans=Integer.MIN_VALUE;
        List<Character> vowel=Arrays.asList('a','e','i','o','u');
        for(int i=0;i<k-1;i++){
            if(vowel.contains(s.charAt(i))) count++;
        }
        int i=0,j=k-1;
        while(j<s.length()){
            if(vowel.contains(s.charAt(j))) count++;
            ans=Math.max(ans,count);
            if(vowel.contains(s.charAt(i))) count--;
            i++;
            j++;

        }
        return ans;
    }
}