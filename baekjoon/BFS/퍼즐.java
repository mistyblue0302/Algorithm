package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼즐 {

    static String corrcet = "123456780";
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                s += num; //103425786
            }
        }
        map.put(s, 0); //key는 찾고자 하는 수, value는 최소 이동 횟수
        System.out.println(bfs(s));
    }

    public static int bfs(String s) {

        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            String temp = queue.poll(); //103425786
            int move = map.get(temp); //0
            int empty = temp.indexOf('0'); //비어있는 칸 찾기 : 1
            int cx = empty % 3; //1 열위치
            int cy = empty / 3; //0 행위치

            if (temp.equals(corrcet)) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; //열
                int ny = cy + dy[i]; //행

                if (nx < 0 || nx > 2 || ny < 0 || ny > 2) {
                    continue;
                }

                int index = nx + ny * 3; //2차원 인덱스를 1차원으로 변환
                char ch = temp.charAt(index);
                String next = temp.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    queue.add(next);
                    map.put(next, move + 1);
                }
            }
        }
        return -1;
    }
}
