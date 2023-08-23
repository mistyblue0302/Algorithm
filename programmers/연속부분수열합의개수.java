import java.util.*;

class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int length = elements.length;
        for (int size = 1; size <= length; size++) {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = 0; j < size; j++) {
                    int index = (i + j) % length;
                    sum += elements[index];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
