class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] answer = new int[image.length][image[0].length];

        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                answer[i][j] = image[i][image.length - 1 - j];
                if(answer[i][j] == 1) {
                    answer[i][j] = 0;
                } else if(answer[i][j] == 0) {
                    answer[i][j] = 1;
                }
            }
        }
        return answer;
    }
}
