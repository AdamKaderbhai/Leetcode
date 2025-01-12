public class Solution{
    public static boolean canBeValid(String s, String locked) {
        int n = s.length();

        
        if (n % 2 != 0) {
            return false;
        }

        
        int openCount = 0; 
        int flexibleCount = 0; 

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                
                if (s.charAt(i) == '(') {
                    openCount++;
                } else { 
                    openCount--;
                }
            } else {
                
                flexibleCount++;
            }

            
            if (openCount < 0) {
                if (flexibleCount > 0) {
                    flexibleCount--;
                    openCount++;
                } else {
                    return false; 
                }
            }
        }

        
        int closeCount = 0; 
        flexibleCount = 0; 

        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                
                if (s.charAt(i) == ')') {
                    closeCount++;
                } else { 
                    closeCount--;
                }
            } else {
                
                flexibleCount++;
            }

           
            if (closeCount < 0) {
                if (flexibleCount > 0) {
                    flexibleCount--;
                    closeCount++;
                } else {
                    return false; 
                }
            }
        }

        
        return true;
    }
}
