package String;

class 이상한문자만들기 {

    public String solution(String s) {
        String answer = "";

        String[] str = s.split("");

        int index = 0;
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];

            if (temp.equals(" ")) {
                index = 0;
                answer += " ";
                continue;
            }

            if (index % 2 == 0) {
                temp = temp.toUpperCase();
                index++;
            } else if (index % 2 != 0) {
                index++;
                temp = temp.toLowerCase();
            }
            answer += temp;
        }
        return answer;
    }
}
