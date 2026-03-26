/*
    https://leetcode.com/problems/isomorphic-strings/description/
    205. Isomorphic Strings

    approch: use hashmap to map each char from  s to t
    edge case:- no char in s map to different char in t

    -> only map s->t not t->s 
    TC:- O(n)
    Sc:- O(n)

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)) return false;
            }else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
            } 
        }
        return true;
    }
}
