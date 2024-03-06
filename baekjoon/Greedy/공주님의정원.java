package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공주님의정원 {

    static class Flower implements Comparable<Flower> {

        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) { // 피는 날짜가 같으면 종료 날짜를 내림차순으로 비교
                return this.end - o.end;
            } else { // 피는 날짜가 다르면 피는 날짜를 오름차순으로 비교
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        Arrays.sort(flowers); // 꽃들을 정렬

        int endDay = 1201;
        int start = 301;
        int count = 0;
        int max = 0; // 현재까지 쵀대 종료일
        int index = 0;

        // 현재 종료일이 12월 1일보다 적은 경우만 가능(12월 1일 초과면 이미 조건 만족했기 때문에)
        while (start < endDay) {
            boolean isFound = false; // 새 꽃 찾은지 여부 확인

            for (int i = index; i < n; i++) {
                if (flowers[i].start > start) { // 종료일보다 시작일이 이후면 의미없음. 종료일에는 시작해야 이어지기 때문에
                    break;
                }

                if (max < flowers[i].end) {
                    isFound = true;
                    max = flowers[i].end;
                    index = i + 1;
                }
            }

            if (isFound) {
                start = max;
                count++;
            } else {
                break;
            }
        }

        if (max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}

