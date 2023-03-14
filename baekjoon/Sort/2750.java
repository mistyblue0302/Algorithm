import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int array[] = new int[n];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int arr : array) {
            sb.append(arr).append("\n");
        }
        System.out.println(sb);
    }
}



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int array[] = new int[n];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array); 

        for (int arr : array) {
            sb.append(arr).append("\n");
        }
        System.out.println(sb);
    }
}


![img](https://github.com/dilmah0203/TIL/blob/main/Image/Arrays.sort().png)

**Arrays.sort()는** 자바에서 기본으로 제공되는 메소드로, 정렬 알고리즘을 구현 할 필요 없이 sort()에 배열만 넣어주면 자동으로 해당 배열이 정렬되어 나온다. Arrays.sort() 의 경우 Dual Pivot Quick Sort 알고리즘을 쓰고 있기 때문에 시간복잡도는 평균 O(NlogN)이다.