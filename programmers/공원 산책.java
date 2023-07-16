class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0; //출발지점 좌표
        int startY = 0;
        int row = park.length;
        int col = park[0].length();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        int x = startX;
        int y = startY;
        for(String route : routes) {
            char direction = route.charAt(0); //E
            int step = Integer.parseInt(route.substring(2)); //2
            int newX = x; //0
            int newY = y; //0
            
            boolean validMove = true;
            for(int i = 0; i < step; i++){
                switch(direction) {
                    case 'N' :
                        newX--;
                        break;
                    case 'S':
                        newX++;
                        break;
                    case 'W':
                        newY--;
                        break;
                    case 'E':
                        newY++;
                        break;
                }
            
                if (newX < 0 || newX >= col || newY < 0 || newY >= row || park[newX].charAt(newY) == 'X') {
                    validMove = false;
                    break;
                }
            }
            if (validMove) {
                x = newX;
                y = newY;
            }
        }
        return new int[]{x, y};
    }
}
