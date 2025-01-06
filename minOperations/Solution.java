class Solution {
    public int[] minOperations(String boxes) {
     
        char[] initialState = boxes.toCharArray();
        int[] result = new int[initialState.length];
        
        for(int i = 0 ; i < result.length ; i++){
            for(int j = 0 ; j < result.length ; j++){
                if(i == j)
                    continue;
                
                if(initialState[j] == '1')
                    result[i] += Math.abs(j - i);
            }   
        }
        return result;
    }
}