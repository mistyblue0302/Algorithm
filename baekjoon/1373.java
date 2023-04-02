import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); //11001100

        if (s.length() % 3 == 1) {
            s = "00" + s;
        }

        if (s.length() % 3 == 2) {
            s = "0" + s;
        }

        StringBuilder sb = new StringBuilder();

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            if (i % 3 == 2) {
                a = num * 1;
            } else if (i % 3 == 1) {
                b = num * 2;
            } else if (i % 3 == 0) {
                c = num * 4;
                sb.append(a + b + c);
            }
        }
        System.out.println(sb.reverse());
    }
}
