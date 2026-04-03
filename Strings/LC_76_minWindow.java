/*
    https://leetcode.com/problems/minimum-window-substring/
    76. Minimum Window Substring

*/

// brute force approach 
class Solution {
    public boolean isEqual(HashMap<Character,Integer> map,HashMap<Character,Integer> windowMap){
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char c=entry.getKey();
            int require=entry.getValue();

            if(windowMap.getOrDefault(c,0)<require) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int n=s.length(), m=t.length();
        HashMap<Character,Integer> windowMap=new HashMap<>();
        if(n<m) return "";
        for(int i=0;i<m-1;i++){
            windowMap.put(s.charAt(i),windowMap.getOrDefault(s.charAt(i),0)+1);
        }
        int l=Integer.MAX_VALUE;
        String ans="";
        int i=0,j=m-1;
        while(j<n && j>=0){
            char ch=s.charAt(j);
            windowMap.put(ch,windowMap.getOrDefault(ch,0)+1);
            if(isEqual(map,windowMap)){
                if(l>j-i+1){
                    l=j-i+1;
                    ans=s.substring(i,j+1);
                }
                windowMap.put(s.charAt(i),windowMap.get(s.charAt(i))-1);
                if(windowMap.get(s.charAt(i))==0) windowMap.remove(s.charAt(i));
                i++;
                while(i<j && !map.containsKey(s.charAt(i))){
                    char c=s.charAt(i);
                    windowMap.put(c,windowMap.get(c)-1);
                    if(windowMap.get(c)==0) windowMap.remove(c);
                    i++;

                }
                while(isEqual(map,windowMap)){
                    if(l>j-i+1){
                        l=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                    char c=s.charAt(i);
                    windowMap.put(c,windowMap.get(c)-1);
                    if(windowMap.get(c)==0) windowMap.remove(c);
                    i++;
                }
            }
            
            j++;
        }
        return ans;


    }
}


// optimal solution using sliding window and hashmap
class Solution {
    
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int n=s.length(), m=t.length();
        HashMap<Character,Integer> windowMap=new HashMap<>();
        if(n<m) return "";
        int l=Integer.MAX_VALUE;
        String ans="";
        int i=0,j=0;
        int require=map.size(),formed=0;
        while(j<n){
            char ch=s.charAt(j);
            windowMap.put(ch,windowMap.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && windowMap.get(ch).intValue()==map.get(ch).intValue()){
                formed++;
            }
             while(i<=j && require==formed){
                    if(l>j-i+1){
                        l=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                    char c=s.charAt(i);
                    windowMap.put(c,windowMap.get(c)-1);
                    
                    if(map.containsKey(c) && windowMap.get(c).intValue()<map.get(c).intValue()){
                        formed--;
                    }
                    i++;
            }
            
            
            j++;
        }
        return ans;


    }
}