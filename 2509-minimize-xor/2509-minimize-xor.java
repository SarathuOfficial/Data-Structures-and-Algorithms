class Solution {
    public int minimizeXor(int num1, int num2) {
        int setbits = Integer.bitCount(num2);
        String binaryString = Integer.toBinaryString(num1);
        StringBuilder res = new StringBuilder(binaryString);

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '1' && setbits > 0) {
                setbits--; 
            } else {
                res.setCharAt(i, '0'); 
            }
        }

        int i = res.length() - 1;
        while (setbits > 0 && i >= 0) {
            if (res.charAt(i) == '0') {
                res.setCharAt(i, '1');
                setbits--;
            }
            i--;
        }

        while (setbits > 0) {
            res.insert(0, '1');
            setbits--;
        }

        return Integer.parseInt(res.toString(), 2);
    }
}
