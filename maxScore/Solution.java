public class Solution {
    public int maxScore(String str) {
        int maxScore = 0;

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);

            int leftZeroCount = 0;
            int rightOneCount = 0;

            for (char ch : left.toCharArray()) {
                if (ch == '0') {
                    leftZeroCount++;
                }
            }

            for (char ch : right.toCharArray()) {
                if (ch == '1') {
                    rightOneCount++;
                }
            }
            int score = leftZeroCount + rightOneCount;
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }
}
