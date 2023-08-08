import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] array;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //3
        array = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(array[i][j], max);
            }
        }
        dfs(array, 0);
        System.out.println(max);
    }

    private static void dfs(int[][] map, int depth) {
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] moved = move(map, i);
            dfs(moved, depth + 1);
        }
    }

    //주어진 배열을 direction 방향으로 이동 시킨 결과를 이차원 배열로 반환
    private static int[][] move(int[][] map, int direction) {
        int[][] newMap = new int[n][n];

        if (direction == 0) { //(-1,0) 왼쪽으로 이동 --> 탐색은 오른쪽 방향
            for (int i = 0; i < n; i++) {
                int baseBlock = -1;
                int nextIdx = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) { //빈칸이면
                        continue;
                    }
                    if (map[i][j] == baseBlock) {
                        newMap[i][nextIdx - 1] = map[i][j] * 2; //곱하기 2가 일어났기 때문에 최댓값 발생의 가능성이 있다.
                        baseBlock = -1;
                        max = Math.max(newMap[i][nextIdx - 1], max);
                    } else { //값이 다른 경우
                        newMap[i][nextIdx] = map[i][j];
                        baseBlock = map[i][j];
                        nextIdx++;
                    }
                }
            }
        } else if (direction == 1) { //(0,1) 위로 이동 --> 탐색은 아래방향
            for (int i = 0; i < n; i++) {
                int baseBlock = -1;
                int nextIdx = 0;
                for (int j = 0; j < n; j++) {
                    if (map[j][i] == 0) { //빈칸이면
                        continue;
                    }
                    if (map[j][i] == baseBlock) {
                        newMap[nextIdx - 1][i] = map[j][i] * 2; //곱하기 2가 일어났기 때문에 최댓값 발생의 가능성이 있다.
                        baseBlock = -1;
                        max = Math.max(newMap[nextIdx - 1][i], max);
                    } else { //값이 다른 경우
                        newMap[nextIdx][i] = map[j][i];
                        baseBlock = map[j][i];
                        nextIdx++;
                    }
                }
            }
        } else if (direction == 2) { //(1,0) 오른쪽으로 이동 --> 탐색은 왼쪽방향
            for (int i = 0; i < n; i++) {
                int baseBlock = -1;
                int nextIdx = n - 1;
                for (int j = n-1; j >= 0; j--) {
                    if (map[i][j] == 0) { //빈칸이면
                        continue;
                    }
                    if (map[i][j] == baseBlock) {
                        newMap[i][nextIdx + 1] = map[i][j] * 2; //곱하기 2가 일어났기 때문에 최댓값 발생의 가능성이 있다.
                        baseBlock = -1;
                        max = Math.max(newMap[i][nextIdx + 1], max);
                    } else { //값이 다른 경우
                        newMap[i][nextIdx] = map[i][j];
                        baseBlock = map[i][j];
                        nextIdx--;
                    }
                }
            }
        } else { //(0,-1) 아래로 이동 --> 탐색은 위방향
            for (int i = 0; i < n; i++) {
                int baseBlock = -1;
                int nextIdx = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (map[j][i] == 0) { //빈칸이면
                        continue;
                    }
                    if (map[j][i] == baseBlock) {
                        newMap[nextIdx + 1][i] = map[j][i] * 2; //곱하기 2가 일어났기 때문에 최댓값 발생의 가능성이 있다.
                        baseBlock = -1;
                        max = Math.max(newMap[nextIdx + 1][i], max);
                    } else { //값이 다른 경우
                        newMap[nextIdx][i] = map[j][i];
                        baseBlock = map[j][i];
                        nextIdx--;
                    }
                }
            }
        }
        return newMap;
    }
}
