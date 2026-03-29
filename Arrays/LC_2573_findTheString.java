/*
https://leetcode.com/problems/find-the-string-with-lcp/?envType=daily-question&envId=2026-03-28

2573. Find the String with LCP

We define the lcp matrix of any 0-indexed string word of n lowercase English letters as an n x n grid such that:

lcp[i][j] is equal to the length of the longest common prefix between the substrings word[i,n-1] and word[j,n-1].
Given an n x n matrix lcp, return the alphabetically smallest string word that corresponds to lcp. If there is no such string, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "aabd" is lexicographically smaller than "aaca" because the first position they differ is at the third letter, and 'b' comes before 'c'.


 */

 class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        Arrays.fill(s, '#');

        char ch = 'a';

        // Step 1: Assign characters
        for (int i = 0; i < n; i++) {
            if (s[i] == '#') {
                if (ch > 'z') return ""; // more than 26 groups not allowed
                s[i] = ch;

                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        s[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 2: Validate LCP matrix
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected = lcp[i][j];
                int actual = 0;

                int x = i, y = j;
                while (x < n && y < n && s[x] == s[y]) {
                    actual++;
                    x++;
                    y++;
                }

                if (actual != expected) return "";
            }
        }

        return new String(s);
    }
}