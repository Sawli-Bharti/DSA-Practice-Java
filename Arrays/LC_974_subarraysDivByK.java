// Problem 974. Subarray Sums Divisible by K

// Given an integer array nums and an integer k, return the number of non-empty subarrays whose sum is divisible by k.
// O(n2) approch using prefix sum that subArraySum(i,j)=prefix[j]-prefix[i-1]
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int[] prefix=new int[n];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0){
                    if(prefix[j]%k==0) count++;
                }else{
                    if((prefix[j]-prefix[i-1])%k==0) count++;
                }
                
            }
            
        }
        return count;
    }
}

// Key Idea

// Instead of checking every subarray (which would take O(n²) time), we use the concept of prefix sums and remainders.

// If:

// prefixSum[j] % k == prefixSum[i] % k

// then the sum of the subarray between (i+1 ... j) is divisible by k.

// Because:

// (prefixSum[j] - prefixSum[i]) % k = 0

// So we store the frequency of each remainder using a HashMap.
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;
            int rem = sum % k;

            if(rem < 0) rem += k;

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem,0) + 1);
        }

        return count;
    }
}