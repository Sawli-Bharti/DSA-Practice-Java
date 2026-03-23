/*
https://leetcode.com/problems/valid-anagram/
242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

🧠 Approach

We use a HashMap to track character frequencies and compare both strings.

🔹 Step 1: Length check
If lengths of s and t are different → they cannot be anagrams
Return false
🔹 Step 2: Count characters of s
Traverse string s
Store frequency of each character in a HashMap
🔹 Step 3: Reduce using string t
Traverse string t
For each character:
If it exists in map → decrement its count
If count becomes 0 → remove it from map
If character not found → return false
🔹 Step 4: Final check
If all characters matched correctly → map becomes empty
Return true

⏱️ Time Complexity (TC)
Traversing s: O(n)
Traversing t: O(n)

👉 Overall TC = O(n)

📦 Space Complexity (SC)
HashMap stores at most 26 characters (for lowercase letters)

👉 SC = O(1) (constant space)
*/

import java.util.HashMap;

public class LC_242_isAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(char c:t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
            }else return false;
        }
        return true;
    }
}
