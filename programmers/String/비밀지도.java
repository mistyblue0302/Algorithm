class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) { //한 변의 길이가 n
        String[] answer = new String[n];
        
        for(int i = 0; i < n;i++){
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            s = String.format("%" + n + "s", s); //5자리의 문자열 형태로 변경, 5자리가 안되면 공백으로 채운다.
            s = s.replaceAll("1", "#");
            s = s.replaceAll("0", " ");
            answer[i] = s;
        }
     
        return answer;
    }
}
