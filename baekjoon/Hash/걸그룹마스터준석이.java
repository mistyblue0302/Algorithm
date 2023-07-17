package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 걸그룹마스터준석이 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<String, String[]> map = new HashMap<>();
        String groupName, problem;
        int groupSize;

        for (int i = 0; i < n; i++) {
            groupName = scanner.next();
            groupSize = scanner.nextInt();
            String[] member = new String[groupSize];
            for (int j = 0; j < groupSize; j++) {
                member[j] = scanner.next();
            }
            Arrays.sort(member);
            map.put(groupName, member);
        }

        int quizType;
        for (int i = 0; i < m; i++) {
            problem = scanner.next();
            quizType = scanner.nextInt();
            if (quizType == 1) {
                for (String s : map.keySet()) {
                    String[] list = map.get(s);
                    for (int j = 0; j < list.length; j++) {
                        if (list[j].equals(problem)) {
                            System.out.println(s);
                            break;
                        }
                    }
                }
            } else {
                String[] list = map.get(problem);
                for (int j = 0; j < list.length; j++) {
                    System.out.println(list[j]);
                }
            }
        }
    }
}
