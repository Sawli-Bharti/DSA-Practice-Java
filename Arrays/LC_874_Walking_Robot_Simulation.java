/*
https://leetcode.com/problems/walking-robot-simulation/?envType=daily-question&envId=2026-04-06

Approach: Simulation
Time complexity O(n*m) where n is the number of commands and m is the number of obstacles
*/

class Solution {
    public char direction(char dir, int command){
        switch(dir){
            case 'E': return (command==-1) ? 'S' : 'N';
            case 'W': return (command==-1) ? 'N' : 'S';
            case 'N': return (command==-1) ? 'E' : 'W';
            case 'S': return (command==-1) ? 'W' : 'E';
        }
        return 'N';
    }

    public boolean isObst(int[][] obstacles, int Rx, int Ry){
        for(int[] o : obstacles){
            if(Rx == o[0] && Ry == o[1]){
                return true;
            }
        }
        return false;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        char dir = 'N';
        int Rx = 0, Ry = 0;
        int maxDist = 0;

        for(int cmd : commands){
            if(cmd == -1 || cmd == -2){
                dir = direction(dir, cmd);
            } else {
                while(cmd-- > 0){
                    int nx = Rx, ny = Ry;

                    if(dir=='N') ny++;
                    else if(dir=='S') ny--;
                    else if(dir=='E') nx++;
                    else nx--;

                    if(isObst(obstacles, nx, ny)){
                        break;
                    }

                    Rx = nx;
                    Ry = ny;

                    maxDist = Math.max(maxDist, Rx*Rx + Ry*Ry);
                }
            }
        }

        return maxDist;
    }
}