class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int count = 0;
        int i = 0;

        while (i <= n - k) {

            boolean found = false;

            // Try every possible END position
            for (int j = i + k - 1; j < n; j++) {

                // Try all possible START positions
                for (int start = i; start <= j - k + 1; start++) {

                    if (isPalindrome(s, start, j)) {

                        count++;

                        // We selected [start...j]
                        i = j + 1;

                        found = true;
                        break;
                    }
                }

                if (found)
                    break;
            }

            if (!found)
                break;
        }

        return count;
    }

    private boolean isPalindrome(String s, int l, int r) {

        while (l < r) {

            if (s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}