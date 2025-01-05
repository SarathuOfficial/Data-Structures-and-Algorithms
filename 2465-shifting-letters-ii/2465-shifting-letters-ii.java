class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder(s);
        int[] prefix = new int[sb.length() + 1];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            if (direction == 1) {
                prefix[start] += 1;
                prefix[end + 1] -= 1;
            } else {
                prefix[start] -= 1;
                prefix[end + 1] += 1;
            }
        }
        int shift = 0;
        for (int i = 0; i < sb.length(); i++) {
            shift += prefix[i];

            int originalChar = sb.charAt(i) - 'a';
            int newChar = (originalChar + shift) % 26; 
            if (newChar < 0) {
                newChar += 26; 
            }
            sb.setCharAt(i, (char) (newChar + 'a')); 
        }
        return sb.toString();
    }
}


            // int arr[] = shifts[i];
            // for(int j = arr[0];j <= arr[1];j++){
            //     if(arr[2] == 1){
            //         if(sb.charAt(j) == 'z'){
            //             sb.setCharAt(j, 'a');
            //         }else{
            //             char updatedChar = (char) (sb.charAt(j) + 1); 
            //             sb.setCharAt(j, updatedChar);
            //         }
            //     }else{
            //         if(sb.charAt(j) == 'a'){
            //             sb.setCharAt(j, 'z');
            //         }else{
            //             char updatedChar = (char) (sb.charAt(j) - 1); 
            //             sb.setCharAt(j, updatedChar);
            //         }
            //     }
            // }