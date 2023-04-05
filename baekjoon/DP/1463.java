import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int array[] = new int[n + 1]; //n을 1로 만들기 위한 최소 연산 횟수
        array[0] = array[1] = 0;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0 && array[i] > array[i / 2] + 1) {
                array[i] = array[i / 2] + 1;
            }
            if (i % 3 == 0 && array[i] > array[i / 3] + 1) {
                array[i] = array[i / 3] + 1;
            }
        }
        System.out.println(array[n]);
    }
}
