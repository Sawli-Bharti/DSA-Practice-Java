/*
    https://leetcode.com/problems/permutation-in-string/

    approach_ sliding window
    TC:- O(n*26) => O(n)
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }
        int n=s1.length(), m=s2.length();
        if(n>m) return false;
        for(int i=0;i<n-1;i++){
            freq2[s2.charAt(i)-'a']++;
        }
        int i=0,j=n-1;
        while(j<m){
            freq2[s2.charAt(j)-'a']++;
            boolean flag=true;
            for(int k=0;k<26;k++){
                if(freq1[k]!=freq2[k]){
                    flag=false;
                    break;
                }
            }
            if(flag) return true;
            else{
                freq2[s2.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return false;
    }
}