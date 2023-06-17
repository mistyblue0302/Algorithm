package BF;

import java.util.ArrayList;
import java.util.Scanner;

public class 부등호 {

    public static int k;
    public static String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static boolean[] visit = new boolean[10];
    public static String[] signs;
    public static ArrayList<String> lists =new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); //2
        signs = new String[k];

        for (int i = 0; i < signs.length; i++) {
            signs[i] = sc.next();
        }

        permutation(0, "");
        System.out.println(lists.get(lists.size()-1));
        System.out.println(lists.get(0));
    }

    public static void permutation(int count, String s) {
        if (count == k + 1) {
            if (check(s)) {
                lists.add(s);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(count + 1, s + array[i]);
                visit[i] = false;
            }
        }
    }

    public static boolean check(String s) {
        for (int i = 0; i < k; i++) {
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            if (signs[i].equals(">") && a < b) {
                return false;
            }
            if (signs[i].equals("<") && a > b) {
                return false;
            }
        }
        return true;
    }
}
