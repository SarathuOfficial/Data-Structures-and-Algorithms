class Solution {
    public String clearDigits(String s) {
        int digits = 0;
        int marked = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1;i >= 0;i--){
            if(Character.isDigit(s.charAt(i))){
                marked++;
            }else{
                if(marked == 0){
                    sb.append(s.charAt(i));
                }else{
                    marked--;
                }
            }
        }

        return sb.reverse().toString();
    }
}