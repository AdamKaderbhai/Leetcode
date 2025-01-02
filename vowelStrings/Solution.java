package vowelStrings;


public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n+1];

        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + (startsAndEndsWithVowel(words[i]) ? 1 : 0);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefixSum[right+1] - prefixSum[left];
        }
        return result;
    }
    private boolean startsAndEndsWithVowel(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        return "aeiou".indexOf(lastChar) != -1 && "aeiou".indexOf(firstChar) != -1;
    }
    
}
