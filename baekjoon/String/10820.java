import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = " ";

        while ((s = br.readLine()) != null) {
            int array[] = new int[4];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    array[0]++;
                }
                if (c >= 'A' && c <= 'Z') {
                    array[1]++;
                }
                if (c >= '0' && c <= '9') {
                    array[2]++;
                }
                if (c == ' ') {
                    array[3]++;
                }
            }

            System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
        }
    }
}
