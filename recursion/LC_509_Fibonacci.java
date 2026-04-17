/*
    https://leetcode.com/problems/fibonacci-number/description/
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1  
F(n) = F(n - 1) + F(n - 2), for n > 1.
*/
/*
Memoization approach:- in memoization we store the results of the subproblems in a map so that we can avoid redundant calculations and improve the time complexity from exponential to linear.

Note -> we can solve it without memoization as well, but it will be exponential time complexity this way we can get linear time complexity */

class Solution {
    HashMap<Integer,Integer> memo=new HashMap<>();
    public int fib(int n) {
        if(n==0 || n==1) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int result=fib(n-1)+fib(n-2);
        memo.put(n,result);
        return result;
    }
}