package DFS;

class 단체사진찍기 {

    public boolean[] visited= new boolean[8];
    public char[] array = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};;
    public String[] s;
    public int answer = 0;

    public int solution(int n, String[] data) {
        s = data;
        dfs("", 0);
        return answer;
    }

    public void dfs(String str, int len) {
        if (len == array.length) {
            if (isPossible(str)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(str + array[i], len + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPossible(String str) {
        for (String temp : s) {
            int index = str.indexOf(String.valueOf(temp.charAt(0)));
            int index2 = str.indexOf(String.valueOf(temp.charAt(2)));
            char operand = temp.charAt(3);
            int diff = Integer.parseInt(String.valueOf(temp.charAt(4)));
            int realDiff = Math.abs(index - index2) - 1;

            if ((operand == '<') && (realDiff >= diff)) {
                return false;
            } else if ((operand == '>') && (realDiff <= diff)) {
                return false;
            } else if ((operand == '=') && (realDiff != diff)) {
                return false;
            }
        }
        return true;
    }

