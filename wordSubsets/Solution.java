import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] maxFreq = new int[26];
        for (String word2 : words2) {
            int[] freq = countFrequency(word2);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }


        List<String> result = new ArrayList<>();
        for (String word1 : words1) {
            int[] freq1 = countFrequency(word1);
            if (isUniversal(freq1, maxFreq)) {
                result.add(word1);
            }
        }
        return result;
    }

    
    private boolean isUniversal(int[] freq1, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    
    private int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}