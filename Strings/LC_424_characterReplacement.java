/*
    https://leetcode.com/problems/longest-repeating-character-replacement/
*/

class Solution {
    public int max(int[] freq){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            max=Math.max(max,freq[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        
        int n=s.length();
        int ans=Integer.MIN_VALUE;
        // Brute Force
        // for(int i=0;i<n;i++){
        //     int[] freq=new int[26];
        //     int maxCount=0;
        //     for(int j=i;j<n;j++){
        //         freq[s.charAt(j)-'A']++;
        //         maxCount=max(freq);
        //         if((j-i+1)-maxCount<=k) ans=Math.max(ans,j-i+1); 
        //     }
        // }


        // optimal approach: sliding window
        int i=0,j=0;
        int[] freq=new int[26];
        while(j<n){
            freq[s.charAt(j)-'A']++;
            int maxCount=max(freq);
            if((j-i+1)-maxCount<=k) ans=Math.max(ans,j-i+1);
            else{
                freq[s.charAt(i)-'A']--;
                i++;
            }
            j++;

        }
        return ans;
    }
}