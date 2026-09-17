class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        final int INF = 1_000_000;
        Arrays.fill(prefix, INF);
        Arrays.fill(suffix, INF);

        // 1. Fill prefix array: prefix[i] = min length of valid subarray ending at or before index i
        int left = 0, currentSum = 0, minLen = INF;
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            if (currentSum == target) {
                minLen = Math.min(minLen, right - left + 1);
            }
            prefix[right] = minLen;
        }

        // 2. Fill suffix array: suffix[i] = min length of valid subarray starting at or after index i
        int right = n - 1;
        currentSum = 0;
        minLen = INF;
        for (int l = n - 1; l >= 0; l--) {
            currentSum += arr[l];
            while (currentSum > target && l <= right) {
                currentSum -= arr[right];
                right--;
            }
            if (currentSum == target) {
                minLen = Math.min(minLen, right - l + 1);
            }
            suffix[l] = minLen;
        }

        // 3. Find min sum of non-overlapping subarrays by splitting at index i
        int result = INF;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] != INF && suffix[i + 1] != INF) {
                result = Math.min(result, prefix[i] + suffix[i + 1]);
            }
        }

        return result >= INF ? -1 : result;
    }
}