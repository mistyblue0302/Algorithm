package String;

class 괄호변환 {

    public String solution(String p) {
        //빈 문자열인 경우 빈 문자열 반환
        if (p.length() == 0) {
            return "";
        }

        String u = ""; //u는 균형잡힌 괄호 문자열로 더 이상 분리할 수 없어야 하며
        String v = ""; //v는 빈 문자열이 될 수 있다.

        int count = 0;
        //균형잡인 괄호 문자열 판단
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) { //균형잡힌 괄호면 u,v를 지정하고 반복문 종료
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (check(u)) { //균형잡힌 괄호면 올바른 괄호인지 판단하고 참이면 3-1 수행
            return u + solution(v);
        }

        //올바른 괄호가 아니라면
        String result = "(" + solution(v) + ")";
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                result += ')';
            } else {
                result += '(';
            }
        }
        return result;
    }

    //올바른 괄호인지 판단
    public boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}