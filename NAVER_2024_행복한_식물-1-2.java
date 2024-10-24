private static int[] happyFlowers(int[] emotions, int[] orders) {
	int[] result = new int[orders.length];
	Map<Integer, int[]> map = new HashMap<>(); // 각 식물의 상태를 저장

	/*
    	{
        	1 -> [2, 2],  // 1번 식물: 현재 상태 2, 초기 상태 2
        	2 -> [3, 3],  // 2번 식물: 현재 상태 3, 초기 상태 3
        	3 -> [1, 1],  // 3번 식물: 현재 상태 1, 초기 상태 1
        	4 -> [2, 2]   // 4번 식물: 현재 상태 2, 초기 상태 2
   	 }
	*/
	int num = 1;
	for(int e : emotions) {
		map.put(num++, new int[]{e, e});
	}

	int i = 0;

	// 사이클을 처리(사이클 1, 사이클 2...)
	for(int o : orders) { // o = 1
		Set<Integer> set = new HashSet<>(); // 상태가 0이 된 식물을 저장
		
		// 모든 식물이 한 사이클마다 상태값 1 감소
		for(Map.entry<Integer, int[]> entry : map.entrySet()) { // 모든 key-value 쌍을 순회
			int[] states = entry.getValue(); // 식물의 상태 배열, 처음엔 [2,2]
			if(states[0] > 0) states[0]--; // 현재 상태가 0보다 크다면 상태값 1 감소 	
		/*											
		{												
    		1 -> [1, 2],  // 현재 상태는 1, 초기 상태는 2
    		2 -> [2, 3],  // 현재 상태는 2, 초기 상태는 3
    		3 -> [0, 1],  // 현재 상태는 0 (더 이상 기분이 좋지 않음), 초기 상태는 1
    		4 -> [1, 2]   // 현재 상태는 1, 초기 상태는 2
   	 	}
		*/
			// 상태가 0이되면 저장(더 이상 기분이 좋아지지 않음, 물을 받은 식물 제외)
			// o는 물을 주는 식물번호이고 entry.getKey()는 현재 순회중인 식물번호인데
			// 만약 3번식물이 물을 받으면 초기 상태로 돌아가야 하기 때문에 제외시켜야 한다.
			if(states[0] == 0 && entry.getKey() != o) { 
				set.add(entry.getKey());
			}
		}
		
		// 상태가 0이 된 식물 제거
		for(int plant : set) {
			map.remove(plant);
		}

		// 물을 받은 식물은 초기 상태로 복구
		if(map.containsKey(o)) { 
			int[] v = map.get(o); 
			v[0] = v[1]; // [2,2] 초기 상태로 복구
		}

		result[i++] = map.size();
	}
	return result;
}
