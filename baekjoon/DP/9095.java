import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); //3

        int array[] = new int[11];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i <= 10; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }

        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(array[a]);
        }
    }
}
