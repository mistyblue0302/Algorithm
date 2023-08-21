package DFS;

import java.util.*;

class 거리두기확인하기 {
    public int[] solution(String[][] places) { //각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] map = places[i];
            boolean flag = false;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (map[j].charAt(k) == 'P') {
                        if (isExistPerson(j, k, map)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    answer[i] = 0;
                    break;
                }
            }
            if (!flag) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    public boolean isExistPerson(int j, int k, String[] map) {
        //맨해튼 거리 1 확인
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nx = j + dx[i];
            int ny = k + dy[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (map[nx].charAt(ny) == 'P') {
                return true;
            }
        }

        //맨해튼 거리 2 확인(직선)
        int[] dx2 = {0, -2, 0, 2};
        int[] dy2 = {2, 0, -2, 0};
        for (int i = 0; i < 4; i++) {
            int nx = j + dx2[i];
            int ny = k + dy2[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (map[nx].charAt(ny) == 'P') {
                if (map[(j + nx) / 2].charAt((k + ny) / 2) != 'X') {
                    return true;
                }
            }
        }

        //맨해튼 거리 2 확인(대각선)
        int[] dx3 = {1, 1, -1, -1};
        int[] dy3 = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = j + dx3[i];
            int ny = k + dy3[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (map[nx].charAt(ny) == 'P') {
                if (!(map[j].charAt(ny) == 'X' && map[nx].charAt(k) == 'X')) {
                    return true;
                }
            }
        }
        return false;
    }
}