package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 싸이버개강총회 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time[] = br.readLine().split(" ");

        String s = time[0]; //개강총회 시작 시간
        String e = time[1]; //개강총회 종료 시간
        String q = time[2]; //개강총회 스트리밍 종료 시간

        String str;
        HashSet<String> entrance = new HashSet<>();
        HashSet<String> exit = new HashSet<>();

        int count = 0;
        String times[] = new String[2];

        while ((str = br.readLine()) != null) {
            times = str.split(" ");
            if (s.compareTo(times[0]) >= 0) { //입장 확인 여부 조회
                entrance.add(times[1]);
            } else if (e.compareTo(times[0]) <= 0
                && q.compareTo(times[0]) >= 0) { //퇴장 확인 여부
                exit.add(times[1]);
            }
        }
        for (String chances : entrance) {
            if (exit.contains(chances)) { //입장한 사람중에 알맞게 퇴장한 사람이 있다면
                count++;
            }
        }
        System.out.println(count);
    }
}
