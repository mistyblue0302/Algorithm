import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String s = sc.next(); 
            int number = 0;

            switch (s) {
                case "add":
                    number = sc.nextInt();
                    set.add(number);
                    break;
                case "remove":
                    number = sc.nextInt();
                    set.remove(number);
                    break;
                case "check":
                    number = sc.nextInt();
                    if (set.contains(number)) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "toggle":
                    number = sc.nextInt();
                    if (set.contains(number)) {
                        set.remove(number);
                    } else {
                        set.add(number);
                    }
                    break;
                case "all":
                    for (int k = 0; k < 20; k++) {
                        set.add(k + 1);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
