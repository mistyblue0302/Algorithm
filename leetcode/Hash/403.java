class Solution {
    public boolean canCross(int[] stones) {

        //돌 정보와 점프 너비
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++) { 
            map.put(stones[i], new HashSet<Integer>());
        }

        map.get(0).add(0);
        for(int i = 0; i < stones.length; i++) {
            for(int jump : map.get(stones[i])) {
                for(int j = jump - 1; j <= jump + 1; j++) {
                    //전진만 가능하다(점프의 크기가 1이상), 맵에 돌 정보가 있다면
                    if(j > 0 && map.containsKey(stones[i] + j)) {
                        map.get(stones[i] + j).add(j);
                    }
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
