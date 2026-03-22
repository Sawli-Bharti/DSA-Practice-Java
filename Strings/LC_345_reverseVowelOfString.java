/*
    https://leetcode.com/problems/reverse-vowels-of-a-string/
    345. Reverse Vowels of a String
    Input: s = "IceCreAm"
    Output: "AceCreIm"
    Approach used: Two pointer approach
    Time complexity: O(n)
        Space complexity: O(1)
        when i and j both have vowels then swap the characters and mover the pointers towards the center of the string
        if the character at i is not a vowel then move i forward and if the character at j is not a vowel then move j backward
*/

class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        int i=0,j=n-1;
        List<Character> vowel=Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        while(i<=j){
            StringBuilder st=new StringBuilder(s);
            if(vowel.contains(st.charAt(i)) && vowel.contains(st.charAt(j))){
                char c=st.charAt(i);
                st.setCharAt(i,st.charAt(j));
                st.setCharAt(j,c);
                s=st.toString();
                i++;
                j--;
            }else if(vowel.contains(st.charAt(i))){
                j--;
            }else{
                i++;
            }
        }
        return s;
    }
}