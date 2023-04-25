import java.util.Scanner;

public class Main {

    static int array[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        array = new int[4];

        int winner = 0; //우승자
        int sum = 0; //우승자 점수 
        int max = 0; //가장 큰 점수

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j] = sc.nextInt();
                sum += array[j];
            }
            if (max < sum) {
                max = sum;
                winner = i + 1;
            }
            sum = 0;
        }

        System.out.println(winner + " " + max);
    }
}
