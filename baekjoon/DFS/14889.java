import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] array;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }
    
    public static void dfs(int depth, int at) {
        if (depth == n / 2) {
			/*
			 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
            diff();
            return;
        }

        for (int i = at; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;    // 방문으로 변경
                dfs(depth + 1, i + 1);    // 재귀 호출
                visit[i] = false;    // 재귀가 끝나면 비방문으로 변경
            }
        }
    }

    // 두 팀의 능력치 차이를 계산하는 함수 
    public static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀
                if (visit[i] == true && visit[j] == true) {
                    start += array[i][j];
                    start += array[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false라면 링크팀
                else if (visit[i] == false && visit[j] == false) {
                    link += array[i][j];
                    link += array[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        int difference = Math.abs(start - link);
		
		/*
		  두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		  더이상의 탐색 필요없이 0을 출력하고 종료
		 */
        if (difference == 0) {
            System.out.println(difference);
            System.exit(0);
        }

        min = Math.min(difference, min);
    }
}
