import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(moveNumbers(100, 70, new int[]{95, 90, 80, 80, 80, 70, 70, 30, 10}, 4)); // 3
        System.out.println(moveNumbers(100, 82, new int[]{100, 97, 97, 92, 87, 77, 77, 72, 72}, 4)); // 4
        System.out.println(moveNumbers(2000, 1998, new int[]{2000, 2000, 2000, 2000, 1999}, 5)); // -1
    }

    private static int moveNumbers(int cap, int k, int[] score, int m) {
        Set<Integer> set = new HashSet<>();
        Deque<int[]> upper = new LinkedList<>();
        Deque<int[]> lower = new LinkedList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] > k) {
                upper.addLast(new int[]{score[i], i});
            } else if (score[i] < k) {
                lower.addLast(new int[]{score[i], i});
            }
        }

        if (upper.size() < m) return 0;

        while (upper.size() >= m) {
            if (lower.size() == 0) return -1;

            int[] upperElement = upper.peekLast(); // 80, 3
            int[] lowerElement = lower.peekLast(); // 20, 8
            int diff = Math.min(upperElement[0] - k, k - lowerElement[0]); // 10, 50 -> 10

            set.add(upperElement[1]);
            set.add(lowerElement[1]); // 4, 8, 3

            upperElement[0] -= diff; // 80 - 10 = 70
            lowerElement[0] += diff; // 20 + 10 = 30

            if(upperElement[0] == k) {
                upper.pollLast();
            }

            if(lowerElement[0] == k) {
                lower.pollLast();
            }
        }
        return set.size();
    }
}
