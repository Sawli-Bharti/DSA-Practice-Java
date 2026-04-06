/*
https://leetcode.com/problems/robot-return-to-origin/description/?envType=daily-question&envId=2026-04-05

approach: Simulation
Time complexity O(n) where n is the length of moves string

notes: main logic robot can be its in origin only if U==D and L==R
Time complexity O(n) where n is the length of moves string
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int[] mov=new int[2]; //U,L
        for(char c:moves.toCharArray()){
            if(c=='D'){
                mov[0]--;
            }else if(c=='R'){
                mov[1]--;
            }else if (c=='L') mov[1]++;
            else mov[0]++;
        }
        for(int a:mov){
            if(a!=0) return false;
        }
        return true;
    }
}