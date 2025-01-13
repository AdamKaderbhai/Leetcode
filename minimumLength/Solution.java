public class Solution {
    public int minimumLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean removed = true;

        while (removed) {
            removed = false;
            for (int i = 1; i < sb.length() - 1; i++) {
                char current = sb.charAt(i);
                int left = i - 1;
                int right = i + 1;

                while (left >= 0 && sb.charAt(left) != current) {
                    left--;
                }
                while (right < sb.length() && sb.charAt(right) != current) {
                    right++;
                }

                if (left >= 0 && right < sb.length() && sb.charAt(left) == current && sb.charAt(right) == current) {
                    sb.deleteCharAt(right);
                    sb.deleteCharAt(left);
                    removed = true;
                    break;
                }
            }
        }

        return sb.length();
    }

}