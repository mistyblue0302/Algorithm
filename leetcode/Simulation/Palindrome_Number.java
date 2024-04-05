class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int point1 = 0;
        int point2 = s.length() - 1;

        while(point1 < point2) {
            if(s.charAt(point1) == s.charAt(point2)) {
                point1++;
                point2--;
            } else {
                return false;
            }
        }
        return true;
    }
}
