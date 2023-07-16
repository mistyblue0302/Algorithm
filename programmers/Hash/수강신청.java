package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken()); //3
        int l = Integer.parseInt(st.nextToken()); //8

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            set.add(s);
            if (set.contains(s)) {
                set.remove(s);
                set.add(s);
            }
        }

        int count = 0;
        for (String s : set) {
            count++;
            System.out.println(s);
            if(count == k) {
                break;
            }
        }
    }
}