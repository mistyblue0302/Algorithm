import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //이동하려고 하는 채널
        int m = sc.nextInt(); //고장난 버튼의 개수

        //0부터 9까지의 숫자가 버튼이 고장났는지
        boolean[] broken = new boolean[10];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //공백 기준으로 데이터를 입력받는다.
            broken[a] = true;
        }

        int result = Math.abs(n - 100);  //+와 -만 누를 경우

        //i = 0부터 999999까지 돌면서 (n 최대값이 500,000이므로 6자리수 중 최대 값까지 검사
        //숫자를 누르고 n과 차이만큼 +나 -를 누를 경우
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            // 숫자 버튼으로 이동 가능한지 체크(가능)
            boolean isBreak = false;
            for (int j = 0; j < length; j++) { //5457이면 4번 반복
                int button = s.charAt(j) - '0'; //5, 4, 5, 7
                if (broken[button]) { //고장난 버튼이면
                    isBreak = true;
                    break; //탐색 안하고 빠져나온다 (반복문인 for문으로)
                }
            }
            if (!isBreak) { //고장난 버튼이 아니라면(5459)
                //n과의 차이 값 (차이만큼 +나 -를 눌러야함) + 자릿수(버튼을 자릿수만큼 눌러야하기 때문)
                int count = Math.abs(n - i) + s.length(); //2 + 4 = 6
                result = Math.min(result, count);
            }
        }
        System.out.println(result);
    }
}
