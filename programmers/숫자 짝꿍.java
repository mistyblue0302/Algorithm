class Solution {
     public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        for(String a : X.split("")){
            arrX[Integer.parseInt(a)]++; 
        }

        for(String b : Y.split("")){
            arrY[Integer.parseInt(b)]++; 
        }

        for(int i = 9; i >= 0; i--) { //큰 수가 가장 앞자리에 와야하기 때문에 for문을 거꾸로 돌려 가며 공통된 숫자를 추출
            if(arrX[i] > 0 && arrY[i] > 0){
                int temp = Math.min(arrX[i], arrY[i]);
                for(int j = 0; j < temp; j++){
                    sb.append(i);
                }
            }
        }

        if (sb.length() > 0){
            answer = sb.charAt(0)=='0'? "0": sb.toString();
        } else {
            answer = "-1";
        }

        return answer;
    }
}
