package String;

import java.util.*;

class 튜플 {
    public ArrayList<Integer> solution(String s) {
        String[] nums = s.split("},");

        for(int i = 0; i < nums.length; i++){
            String str = nums[i].replace("{", "").replace("}", "");
            nums[i] = str;
        }

        Arrays.sort(nums, new Comparator<String>() { //문자열 길이순 정렬
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for(String n : nums) {
            String[] temp = n.split(",");
            for(int i = 0; i < temp.length; i++) {
                int num = Integer.parseInt(temp[i]);
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        return list;
    }
}
