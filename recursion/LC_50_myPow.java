/*

https://leetcode.com/problems/powx-n/description/
 */

 /*
 if we use normal recursion then we will get stackoverflow for large values of n,  
 
  approach:- we can solve this problem using recursion and divide and conquer approach. we can divide the problem into two subproblems, one for the even case and one for the odd case. for the even case we can simply return the half of the result, for the odd case we can return the half of the result multiplied by x. this way we can reduce the time complexity from O(n) to O(log n).
 */

 class Solution {
    public double pow(double x, int n){
        
        if(n==0) return 1;
        double half=pow(x,n/2);
        if(n%2==0){
            return half*half;
        }else return x*half*half;
        
    }
    public double myPow(double x, int n) {
        if(n<0) {x=1/x;
            n=Math.abs(n);
        }
        return pow(x,n);
    }
}