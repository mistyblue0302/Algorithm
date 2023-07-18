package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열 {

    public static Map<Long, Long> map = new HashMap<>();
    public static long N;
    public static long P;
    public static long Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        find(N);
        System.out.println(map.get(N));
    }

    public static long find(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long a = find((long) Math.floor(n / P));
        long b = find((long) Math.floor(n / Q));
        map.put(n, a + b);
        return a + b;
    }
}