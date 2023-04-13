import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[9];

        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }

        int x = 0;
        int y = 0;

        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++)  {
                if(sum - array[i] - array[j] == 100) {
                    x = array[i];
                    y = array[j];
                    break;
                }
            }
        }

        Arrays.sort(array);

        for(int i = 0; i < array.length; i++) {
            if(array[i] == x || array[i] == y)
                continue;
            System.out.println(array[i]);
        }

    }
}
