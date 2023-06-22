package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에너지모으기 {

    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(list, 0);
        System.out.println(max);
    }

    public static void dfs(List<Integer> list, int sum) {
        if(list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int energy = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(list, sum + energy);
            list.add(i, temp);
        }
    }
}
