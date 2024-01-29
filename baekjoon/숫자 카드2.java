import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);	// 이분 탐색을 하기 위해서 정렬.

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(' ');
        }
        System.out.println(sb);
    }
  
    private static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= arr[mid]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
  
    private static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target >= arr[mid]) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}
