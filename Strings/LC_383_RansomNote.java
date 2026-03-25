/*

https://leetcode.com/problems/ransom-note/

383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

approach : use hashmap to store the frequency of characters in magazine. Then, iterate through ransomNote and check if each character is present in the hashmap with a positive count. If it is, decrement the count in the hashmap. If any character is not present or has a count of zero, return false. If we successfully check all characters in ransomNote, return true.
 */

import java.util.HashMap;


    class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else map.put(c,1);
        }

        for(char c:ransomNote.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
            }else return false;
        }
        return true;
    }
}

