/*
    https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/?envType=daily-question&envId=2026-04-17
*/

/*
    problem statement:-
    You are given an integer array nums.

A mirror pair is a pair of indices (i, j) such that:

0 <= i < j < nums.length, and
reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).

If no mirror pair exists, return -1.

intinuition:
1. store indices of each number in a map
2. for each number, find its mirror and check if it exists in the map
3. if it exists, find the minimum distance between indices of the number and its mirror using binary search
TC- O(n log n) where n is the length of the input array (due to sorting the indices for each number)
SC- O(n) for storing the indices in the map
*/

class Solution {
    public int reverse(int n){
        int num=0;
        while(n>0){
            num*=10;
            num+=(n%10);
            n/=10;
        }
        return num;
    }
    public int minMirrorPairDistance(int[] nums) {
        int d=Integer.MAX_VALUE;
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        for(int i=0;i<n;i++){
            int mirror=reverse(nums[i]);
            List<Integer> list=map.getOrDefault(mirror,new ArrayList<>());
            if(list.size()==0) continue;
            int idx=-1;
            int l=0,r=list.size()-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(list.get(mid)<i){
                    idx=list.get(mid);
                    l=mid+1;
                }
                else r=mid-1;
            }
            
            if(idx>i) d=Math.min(d,Math.abs(i-idx));
            if(d==1) return d;

        }
        return (d==Integer.MAX_VALUE)?-1:d;
    }
}
