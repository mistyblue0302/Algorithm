package Simulation;

import java.util.*;

class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, new Comparator<String[]>() { //우선 예약 시간을 오름차순으로 정렬한다.
            @Override
            public int compare(String[] a, String[] b) {
                if(a[0].equals(b[0])) {
                    return a[1].compareTo(b[1]);
                } else {
                    return a[0].compareTo(b[0]);
                }
            }
        });

        int[][] array = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));

            endTime += 10;
            if(endTime % 100 >= 60) { //10분을 더해줬을 때 60분이 넘을 경우 처리
                endTime += 40;
            }
            array[i][0] = startTime;
            array[i][1] = endTime;
        }

        List<Integer> list = new ArrayList<>(); //객실 수를 할당한다.
        for(int i = 0; i < array.length; i++) {
            Collections.sort(list);
            boolean flag = false;
            for(int j = 0; j < list.size(); j++) {
                if(array[i][0] >= list.get(j)) {
                    flag = true;
                    list.set(j, array[i][1]);
                    break;
                }
            }
            if(!flag) {
                list.add(array[i][1]);
            }
        }

        return list.size();
    }
}
