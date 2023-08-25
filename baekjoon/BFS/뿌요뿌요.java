import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뿌요뿌요 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] array;
    static boolean[][] visited;
    static List<int[]> list;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        while (true) {
            boolean flag = false; //정답 개수 카운트를 위한 선언
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (array[i][j] != '.') { //만약 빈공간이 아니고 뿌요가 있다면
                        char color = array[i][j]; //색 입력받기
                        visited = new boolean[12][6];
                        list = new ArrayList<>();
                        bfs(i, j, color); //좌표 정보와 색 정보를 주고 탐색
                        if (list.size() >= 4) { //리스트의 사이즈를 기준으로 뿌요의 개수 판별(4개 이상)
                            flag = true;
                            for (int[] lists : list) {
                                int row = lists[0];
                                int column = lists[1];
                                array[row][column] = '.'; //터뜨려서 없앤다. (.으로 초기화)
                            }
                        }
                    }
                }
            }
            if (!flag) {
                break;
            } else { //동시에 터뜨려지는건 카운트 하나로 판별해야 하므로 처음 2차원 배열을 탐색하여 bfs를 돌린다.
                count++;
            }
            fallPuyo();
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        list.add(new int[]{x, y}); //리스트에 좌표 저장
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cx = temp[0];
            int cy = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx > 11 || ny < 0 || ny > 5) continue;

                if (array[nx][ny] == color && !visited[nx][ny]) { //상하좌우 탐색하여 색이 같다면
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny}); //리스트에 해당 좌표를 저장
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void fallPuyo() {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (array[j][i] != '.') {
                    queue.add(array[j][i]);
                }
                array[j][i] = '.';
            }
            int h = 11;
            while (!queue.isEmpty()) {
                array[h][i] = queue.poll();
                h--;
            }
        }
    }
}
