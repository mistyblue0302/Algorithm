import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[26];

        for (int i = 0; i < array.length; i++) {
            array[i] = -1; //단어가 포함되어 있지 않은 경우 : -1
        }

        String s = br.readLine(); //baekjoon

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //b

            if (array[c - 97] == -1) {
                array[c - 97] = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
