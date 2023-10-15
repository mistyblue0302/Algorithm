import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] array = new int[w];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < w - 1; i++) { //첫 인덱스와 마지막 인덱스에는 빗물이 고일 수 없다.
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) { //먼저 인덱스 1 기준으로 왼쪽값 판별
                left = Math.max(left, array[j]);
            }

            for (int k = i + 1; k < w; k++) { //인덱스 1 기준으로 오른쪽값 판별
                right = Math.max(right, array[k]);
            }

            if (array[i] < left && array[i] < right) { //양쪽 벽이 높아서 물이 고인다면
                result += Math.min(left, right) - array[i];
            }
        }

        System.out.println(result);
    }
}
