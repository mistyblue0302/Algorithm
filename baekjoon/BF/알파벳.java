package BF;

import java.util.Scanner;

public class 알파벳 {

    static int r;
    static int c;
    static int[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int answer = 0; // 최대칸의 수

    public static void dfs(int x, int y, int count) {
        if (visit[map[x][y]]) { // 이미 지나간 알파벳? True -> answer에 값 증가.
            answer = Math.max(answer, count); // 지나간 곳의 알파벳을 다시 만났다면 answer == count가 되는 것.
            return; // 조건만족 => 리턴
        } else {
            visit[map[x][y]] = true; // 현재 말이 있는 곳의 알파벳 체크
            for (int i = 0; i < 4; i++) { // 고정 코드
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < r && cy < c) {
                    dfs(cx, cy, count + 1); // count++가 아니라 count+1이다.
                }
            }

            visit[map[x][y]] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); // 지도 세로 길이
        c = sc.nextInt(); // 지도 가로 길이
        map = new int[r][c]; // 지도 배열

        // 지도에 글자 정보 담기.
        for (int x = 0; x < r; x++) {
            String s = sc.next();
            for (int y = 0; y < c; y++) {
                map[x][y] = s.charAt(y) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }
}