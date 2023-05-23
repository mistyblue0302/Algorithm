mport java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static boolean[] visit = new boolean[10];
    public static String[] sign; //부등호를 담는 배열
    public static int n;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //2
        sign = new String[n];
        
        for (int i = 0; i < n; i++) {
            sign[i] = sc.next();
        }

        // 부등호를 만족하는 최소 값과 최대 값을 출력
        // 첫 자리가 0인 경우도 정수에 포함
        permutation(0, "");
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void permutation(int count, String s) {
        if (count == n + 1) {
            if (check(s)) {
                list.add(s);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(count + 1, s + array[i]);
                visit[i] = false;
            }
        }
    }

    static boolean check(String temp) {
        for (int i = 0; i < n; i++) {
            int a = temp.charAt(i) - '0';
            int b = temp.charAt(i + 1) - '0';
            if (sign[i].equals(">") && a < b) {
                return false;
            }
            if (sign[i].equals("<") && a > b) {
                return false;
            }
        }
        return true;
    }
}
