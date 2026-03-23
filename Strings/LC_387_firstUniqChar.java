/*
    https://leetcode.com/problems/first-unique-character-in-a-string/
387. First Unique Character in a String
Given a string s, return the index of the first non-repeating character in it, or -1 if it does not exist.
 🧠 Approach

We solve the problem in two passes using a HashMap:

🔹 Step 1: Count frequency of each character
Traverse the string.
Store each character and its frequency in a HashMap<Character, Integer>.

👉 After this step, we know how many times each character appears.

🔹 Step 2: Find first unique character
Traverse the string again.
For each character, check its frequency in the map.
The first character with frequency = 1 is our answer.
🔹 Step 3: If no unique character found
Return -1.

Time Complexity (TC)
First loop (counting): O(n)
Second loop (finding): O(n)

👉 Overall TC = O(n)

 Space Complexity (SC)
HashMap stores at most 26 characters (since lowercase English letters)

👉 SC = O(1) (constant space)
*/

import java.util.HashMap;

public class LC_387_firstUniqChar {
     public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}
