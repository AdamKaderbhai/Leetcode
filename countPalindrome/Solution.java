class Solution {
    public static int countUniquePalindromicSubsequences(String s) {
        int n = s.length();
        int[][] left = new int[n][26];
        int[][] right = new int[n][26];
        
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int j = 0; j < 26; j++) {
                    left[i][j] = left[i - 1][j];
                }
            }
            left[i][s.charAt(i) - 'a']++;
        }
        
 
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                for (int j = 0; j < 26; j++) {
                    right[i][j] = right[i + 1][j];
                }
            }
            right[i][s.charAt(i) - 'a']++;
        }
        
        boolean[][] found = new boolean[26][26];
        int count = 0;
     
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (left[i - 1][j] > 0 && right[i + 1][j] > 0) {
                    if (!found[j][s.charAt(i) - 'a']) {
                        found[j][s.charAt(i) - 'a'] = true;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        String s = "abacaba";
        int result = countUniquePalindromicSubsequences(s);
        System.out.println("Number of unique palindromic subsequences of length 3: " + result);
    }
}