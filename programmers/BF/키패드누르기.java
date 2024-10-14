package BF;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int number : numbers) {
            if(number == 0) {
                number = 11;
            }
            
            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;
            } else {
                int leftDistance = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
                int rightDistance = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);
                
                if(leftDistance > rightDistance) {
                    sb.append("R");
                    right = number;
                } else if(rightDistance > leftDistance) {
                    sb.append("L");
                    left = number;
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = number;
                    } else if(hand.equals("left")) {
                        sb.append("L");
                        left = number;
                    }
                }
            }
        }
        return sb.toString();
    }
}
