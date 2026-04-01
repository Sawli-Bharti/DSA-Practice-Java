/*
    https://leetcode.com/problems/robot-collisions/?envType=daily-question&envId=2026-04-01
*/

class Solution {
    
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        List<Integer> ans=new ArrayList<>();
        int n=directions.length();
         // Step 1: index array
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++) idx[i] = i;

        // Step 2: sort indices based on positions
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
        if(n==1) return Arrays.asList(healths[0]);
        Stack<Integer> stack=new Stack<>();

       for(int i:idx){
        if(directions.charAt(i)=='R'){
            stack.push(i);
        }else{
            while (!stack.isEmpty() && healths[i] > 0) {
                    int top = stack.peek();

                    if (healths[top] == healths[i]) {
                        healths[top] = 0;
                        healths[i] = 0;
                        stack.pop();
                        break;
                    } else if (healths[top] > healths[i]) {
                        healths[top]--;
                        healths[i] = 0;
                        break;
                    } else {
                        healths[i]--;
                        healths[top] = 0;
                        stack.pop();
                    }
                }
        }
       }
        for(int a:healths){
            if(a>0) ans.add(a);
        }
        return ans;
        
    }
}