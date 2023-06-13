class Solution {

    public int solution(String dartResult) {
        int answer = 0;

        String temp = "";
        int array[] = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    array[idx] = (int) Math.pow(Integer.parseInt(temp), 1);
                    idx++;
                    temp = "";
                    break;
                case 'D':
                    array[idx] = (int) Math.pow(Integer.parseInt(temp), 2);
                    idx++;
                    temp = "";
                    break;
                case 'T':
                    array[idx] = (int) Math.pow(Integer.parseInt(temp), 3);
                    idx++;
                    temp = "";
                    break;
                case '*':
                    array[idx - 1] *= 2;
                    if (idx > 1) {
                        array[idx - 2] *= 2;
                    }
                    break;
                case '#':
                    array[idx - 1] *= -1;
                    break;
                default:
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }

        return answer;
    }
}
