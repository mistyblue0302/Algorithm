package BF;

import java.util.Scanner;

public class NQueen { //한 열에 퀸은 최대 1개밖에 놓일 수 없다.

    public static int[] array; //열번호를 index, 행번호를 값으로 가지는 배열
    public static int N;
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N];
        dfs(0);
        System.out.println(result);
    }

    //이미 퀸이 배치되어있는 곳과 같은 행, 같은 열,
    //같은 대각선상(열의 차이 == 행의 차이)에 위치하지 않은 자리를 찾아야 한다.
    public static void dfs(int index) { //index : 퀸이 놓여져야 하는 위치
        if (index == N) { //N개의 퀸 배치가 끝나면 result를 증가시켜 가능한 경우의 수를 센다.
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            array[index] = i;
            if (canPut(index)) {
                dfs(index + 1);
            }
        }
    }

    public static boolean canPut(int column) {
        for (int i = 0; i < column; i++) {
            //같은 행에 존재하는 경우
            if (array[column] == array[i]) {
                return false;
            }
            //같은 대각선에 존재하는 경우
            if(column - i == Math.abs(array[column] - array[i])) { //열 차이와 행의 차이를 비교해서 같으면
                return false;
            }
        }
        return true;
    }
}
