import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //어떤 버튼이 고장났을 때, 채널 n으로 이동하기 위해서 버튼을 최소 몇 번 눌러야 하는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //이동하려고 하는 채널 5457
        int m = Integer.parseInt(br.readLine()); //고장난 버튼의 개수 3

        boolean[] broken = new boolean[10]; //0부터 9까지의 숫자가 버튼이 고장났는지

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            broken[a] = true;
        }

        if (n == 100) {  // 예외처리
            System.out.println(0);
        }

        int abs = Math.abs(n - 100); //+와 -만 누를 경우

        //i = 0부터 999999까지 돌면서 (n 최대값이 500,000이므로 6자리수 중 최대 값까지 검사
        //숫자를 누르고 n과 차이만큼 +나 -를 누를 경우
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            // 숫자 버튼으로 이동 가능한지 체크
            boolean isPossible = true;
            for (int j = 0; j < s.length(); j++) { //5457이면 4번 반복
                int button = s.charAt(j) - '0'; //5, 4, 5, 7
                if (broken[button]) { //고장난 버튼이면
                    isPossible = false;
                    break; //탐색 안하고 빠져나온다 (반복문인 for문으로)
                }
            }
            if (isPossible) { //고장난 버튼이 아니라면(5459)
                //n과의 차이 값 (차이만큼 +나 -를 눌러야함) + 자릿수(버튼을 자릿수만큼 눌러야하기 때문)
                int count = Math.abs(n - i) + s.length() ; //2 + 4 = 6
                abs = Math.min(abs, count);
            }
        }
        System.out.println(abs);
    }

}
