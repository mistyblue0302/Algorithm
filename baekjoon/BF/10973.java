import java.util.*;
import java.io.*;

/** 이전 순열을 구현하는 방법

현재 순열을 구성하는 배열을 A라고 하고 i,j는 그 배열의 index 값을 의미한다고 하자. 예를 들어 A={7, 2, 4, 1, 3, 5, 6}이고 i, j는 각각의 index 값이다.

1. 뒤에서부터 A[i-1] <= A[i]를 연속적으로 만족하는 i 중 가장 작은 값을 찾는다.
  → 현재 i값을 기준으로 이후는 모두 오름차순으로 되는 경우를 찾는 다는 것. 
      A배열을 보면 A[i-1] <= A[i]가 되는 가장 작은 i는 1인 3번째(0부터 시작)이다. 즉, i=3이 된다.

2. j >= i 중, A[j] < A[i-1]을 만족하는 가장 큰 j의 값을 찾는다.
  → 현재가 최초 순열 상태이므로 i-1번째 숫자를 변경하여 최종 순열을 찾아야 한다.
      A배열을 기준으로 i-1번째 숫자는 4인데, 그보다 작은 경우는 1, 3이나 그 중 j 값이 가장 큰 경우는 3이다.
      즉, j의 값은 3의 위치인 4가 된다.

3. A[i-1]과 A[j]를 Swap한다.
   → i-1인 2번째 숫자 4와 j인 4번째 숫자 3를 변경한다. A 배열은 다음과 같이 변경된다.
      A={7, 2, 3, 1, 4, 5, 6}

4. i이후의 순열을 모두 뒤집는다.
   → 최초 순열 상태로 만들어야 하므로 i번째부터는 오름차순으로 만들어야 한다. A 배열은 다음과 같이 변경된다.
      A={7, 2, 3, 6, 5, 4, 1}
**/
class Main {

    public static int n;
    public static int array[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //1부터 n까지의 수로 이루어진 순열
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()) {
            for (int val : array) {
                sb.append(val).append(" ");
            }
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    public static boolean nextPermutation() {
        int i = array.length - 1;

        while (i > 0 && array[i - 1] <= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;

        while (array[i - 1] <= array[j]) {
            j--;
        }

        int temp = array[j];
        array[j] = array[i - 1];
        array[i - 1] = temp;

        j = array.length - 1;

        //4. A[i] 부터 순열을 뒤집는다.
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
