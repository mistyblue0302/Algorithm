class Solution {
    public String solution(String new_id) {
       
        String answer;

        // 1단계
        String s = new_id.toLowerCase();

        // 2단계
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_'
                || c == '.') {
                sb.append(c);
            }
        }

        // 3단계
        String s2 = sb.toString().replace("..", ".");
        while (s2.contains("..")) {
            s2 = s2.replace("..", ".");
        }

        // 4단계
        String s3 = s2;
        if (s3.length() > 0) {
            if (s3.charAt(0) == '.') {
                s3 = s3.substring(1, s3.length());
            }
        }
        if (s3.length() > 0) {
            if (s3.charAt(s3.length() - 1) == '.') {
                s3 = s3.substring(0, s3.length() - 1);
            }
        }

        // 5단계
        String s4 = s3;
        if (s4.equals("")) {
            s4 = "a";
        }

        // 6단계
        String s5 = s4;
        if (s5.length() >= 16) {
            s5 = s5.substring(0, 15);

            if (s5.charAt(s5.length() - 1) == '.') {
                s5 = s5.substring(0, s5.length() - 1);
            }
        }

        // 7단계
        StringBuilder sb2 = new StringBuilder(s5);
        if (sb2.length() <= 2) {
            char last = sb2.charAt(sb2.length() - 1);

            while (sb2.length() < 3) {
                sb2.append(last);
            }
        }

        answer = String.valueOf(sb2);
        return answer;
    }
}
    
