/*
    https://leetcode.com/problems/group-anagrams/description/

49. Group Anagrams

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

approach : use a hashmap to group anagrams. The key will be the sorted version of the string, and the value will be a list of strings that are anagrams of each other. Iterate through the input array, sort each string, and add it to the corresponding list in the hashmap. Finally, return the values of the hashmap as a list of lists.

*/

class Solution {
    public List<List<String>> list=new ArrayList();
    public boolean isContains(String s){
        for(int i=0;i<list.size();i++){
            List<String> l=list.get(i);
            if(l.contains(s)) return true;
        }
        return false;
    }
    public boolean isAnagrams(HashMap<Character, Integer> map, String s){
        for(char c:s.toCharArray()){
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)-1);
                        if(map.get(c)==0) map.remove(c);
                    }else break;
        }
            if(map.size()==0) return true;
            return false;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        for(int i=0;i<strs.length;i++){
            if(!isContains(strs[i])){
                List<String> temp=new ArrayList<>();
            temp.add(strs[i]);
            
            for(int j=i+1;j<strs.length;j++){
                if(strs[j].length()!=strs[i].length()) continue;
                HashMap<Character, Integer> map=new HashMap<>();
                for(char c:strs[i].toCharArray()){
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                    }else map.put(c,1);
                }
                if(isAnagrams(map,strs[j])) temp.add(strs[j]);

            }
            list.add(temp);
            }
            
        }
        return list;
    }
}