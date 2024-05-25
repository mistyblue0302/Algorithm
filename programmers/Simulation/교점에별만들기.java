package Simulation;

import java.util.HashSet;
import java.util.Arrays;

class 교점에별만들기 {

    long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<Point> set = new HashSet<>();

        long interceptX, interceptY;
        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long c = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long d = line[j][0];
                long e = line[j][1];
                long f = line[j][2];

                long inclination = a * e - b * d;
                if (inclination == 0) continue; // 두 직선이 평행함

                long x = b * f - c * e;
                if (x % inclination != 0) continue; // x가 정수가 아님

                long y = c * d - a * f;
                if (y % inclination != 0) continue; // y가 정수가 아님

                interceptX = x / inclination;
                interceptY = y / inclination;
                set.add(new Point(interceptX, interceptY));

                minX = Math.min(minX, interceptX);
                minY = Math.min(minY, interceptY);
                maxX = Math.max(maxX, interceptX);
                maxY = Math.max(maxY, interceptY);
            }
        }

        long height = maxY - minY + 1;
        long width = maxX - minX + 1;
        answer = new String[(int)height];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        long nx, ny;
        for (Point p : set) {
            ny = maxY - p.y;
            nx = p.x - minX;
            answer[(int)ny] = answer[(int)ny].substring(0, (int)nx) + "*" + answer[(int)ny].substring((int)nx + 1);
        }

        return answer;
    }

    public class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

