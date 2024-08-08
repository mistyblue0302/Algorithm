class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i : numbers) {
            if(i == 1 || i == 4 || i == 7) {
                sb.append("L");
                left = i;
            } else if (i == 3 || i == 6 || i == 9) {
                sb.append("R");
                right = i;
            } else {
                if(i == 0) {
                    i = 11;
                }
                
                int Left = (Math.abs(i - left) / 3) + (Math.abs(i - left) % 3);
                int Right = (Math.abs(i - right) / 3) + (Math.abs(i - right) % 3);
                
                if(Left > Right) {
                    sb.append("R");
                    right = i;
                } else if(Left < Right) {
                    sb.append("L");
                    left = i;
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = i;
                    } else if(hand.equals("left")) {
                        sb.append("L");
                        left = i;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
