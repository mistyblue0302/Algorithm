import java.util.ArrayDeque;
import java.util.Scanner;


public class Main { //가장 빠른 시간 -> 0초 부터 계산

    public static int n, k;
    public static int time[] = new int[100001];
    public static boolean visited[] = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        time[n] = 0;
        visited[n] = true;

        while (!deque.isEmpty()) {
            int temp = deque.poll();
            int array[] = new int[]{temp * 2, temp - 1, temp + 1};

            for (int i = 0; i < 3; i++) {
                if (array[i] >= 0 && array[i] <= 100000) {
                    if (!visited[array[i]]) {
                        visited[array[i]] = true;
                        if (i == 0) {
                            deque.addFirst(array[i]);
                            time[array[i]] = time[temp];
                        } else {
                            deque.addLast(array[i]);
                            time[array[i]] = time[temp] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(time[k]);
    }
}
