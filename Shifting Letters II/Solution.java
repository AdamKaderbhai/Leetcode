public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] netShifts = new int[n + 1];

        // Calculate net shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int shiftValue = direction == 1 ? 1 : -1;

            netShifts[start] += shiftValue;
            if (end + 1 < n) {
                netShifts[end + 1] -= shiftValue;
            }
        }

        // Apply net shifts to the string
        StringBuilder result = new StringBuilder();
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += netShifts[i];
            char shiftedChar = (char) ((s.charAt(i) - 'a' + currentShift) % 26);
            if (shiftedChar < 0) {
                shiftedChar += 26;
            }
            result.append((char) (shiftedChar + 'a'));
        }

        return result.toString();
    }
}