package Simulation;

import java.util.*;

class 이모티콘할인행사 {
    static int[][] userBuckets;
    static int[] emoticonPrices;
    static int plusMax = 0;
    static int totalMax = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        userBuckets = users;
        emoticonPrices = emoticons;

        dfs(0,0,40,0,new int[users.length]);
        dfs(0,0,30,0,new int[users.length]);
        dfs(0,0,20,0,new int[users.length]);
        dfs(0,0,10,0,new int[users.length]);

        return new int[]{plusMax, totalMax};
    }

    //index : emoticons의 인덱스 판별
    public void dfs(int plus, int total, int discountRate, int index, int[] userTotal) {
        if(index == emoticonPrices.length) {
            if(plusMax < plus) { //플러스 가입자 수를 늘리는 것이 우선이므로 갱신 후, totalMax도 그에맞게 갱신
                plusMax = plus;
                totalMax = total;
            } else if(plusMax == plus) { //플러스 가입자 수가 같다면 두 번째 우선순위인 totalMax를 갱신
                totalMax = Math.max(totalMax, total);
            }
            return;
        }


        for(int i = 0; i < userTotal.length; i++) {
            int current = userTotal[i];
            if(current == -1) continue;

            if(userBuckets[i][0] <= discountRate) {
                double price = emoticonPrices[index] * ((double) (100 - discountRate) / 100);
                //만약 userBuckets의 금액을 넘어가면 이모티콘 플러스 가입
                if(current + price >= userBuckets[i][1]) {
                    userTotal[i] = -1; //-1로 초기화하고
                    plus++;
                    total -= current;
                } else { //그렇지 않으면 이모티콘을 구입
                    total += price;
                    userTotal[i] += price;
                }
            }
        }

        dfs(plus, total, 40, index + 1, Arrays.copyOf(userTotal, userTotal.length));
        dfs(plus, total, 30, index + 1, Arrays.copyOf(userTotal, userTotal.length));
        dfs(plus, total, 20, index + 1, Arrays.copyOf(userTotal, userTotal.length));
        dfs(plus, total, 10, index + 1, Arrays.copyOf(userTotal, userTotal.length));
    }
}
