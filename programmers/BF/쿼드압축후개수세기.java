package BF;

class 쿼드압축후개수세기 {
    public int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        slice(arr, 0, 0, arr.length);
        return answer;
    }

    public void slice(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            int num = arr[x][y];
            answer[num]++;
            return;
        }

        if (check(arr, x, y, size)) {
            return;
        }

        int newSize = size / 2;

        slice(arr, x, y, newSize);
        slice(arr, x, y + newSize, newSize);
        slice(arr, x + newSize, y, newSize);
        slice(arr, x + newSize, y + newSize, newSize);
    }

    public boolean check(int[][] arr, int x, int y, int size) {
        boolean temp = true;
        int num = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) {
                    temp = false;
                }
            }
        }

        if (temp) {
            answer[num]++;
        }

        return temp;
    }
}