import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0; //0의 개수

        //뒷자리가 0일 때 : 2와 5가 곱해져 있을 때(소인수분해하여 2와5가 존재할 경우 뒷자리는0이다.)
        //5의 배수마다 0의 개수가 하나씩 커진다. 입력값이 25!일때는 0의 개수가 1이아닌 2가 증가한다.
        //25 50 75 100처럼 5가 2개씩 들어가는 경우는
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        System.out.println(count);
    }
}
