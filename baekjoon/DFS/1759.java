import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int L, C;
    public static char[] array;
    public static char[] result;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken()); //4
        C = Integer.parseInt(st.nextToken()); //6

        result = new char[L];
        array = new char[C];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < array.length; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int at) {
        if (depth == L) {
            if (isValid()) {
                for (char c : result) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }
        for (int i = at; i < C; i++) {
            result[depth] = array[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static boolean isValid() { //모음이 최소 1개인지 , 자음이 최소 2개인지 확인한다.
        int mo = 0;
        int ja = 0;

        for (char c : result) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
