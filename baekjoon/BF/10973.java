import java.util.*;
import java.io.*;

class Main {

    public static int n;
    public static int array[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //1부터 n까지의 수로 이루어진 순열
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()) {
            for (int val : array) {
                sb.append(val).append(" ");
            }
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    public static boolean nextPermutation() {
        int i = array.length - 1;

        while (i > 0 && array[i - 1] <= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;

        while (array[i - 1] <= array[j]) {
            j--;
        }

        int temp = array[j];
        array[j] = array[i - 1];
        array[i - 1] = temp;

        j = array.length - 1;

        //4. A[i] 부터 순열을 뒤집는다.
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
