/*
    https://leetcode.com/problems/jewels-and-stones/description/

    771. Jewels and Stones
    approach use hashset or map to store jewles and count evrey jewles in stones

    TC:- O(n+m)
    where n-length of jewels and m-length of stones
    Sc-O(n)
 */
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set=new HashSet<>();
        for(char c:jewels.toCharArray()){
            set.add(c);
        }
        int count=0;
        for(char c:stones.toCharArray()){
            if(set.contains(c)) count++;
        }
        return count;
    }
}