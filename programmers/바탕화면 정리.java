class Solution { 
    public int[] solution(String[] wallpaper) { 
        
        int minRow = Integer.MAX_VALUE;
        int minColumn = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        for(int i = 0; i < row ; i++){
            for(int j = 0; j < col ; j++){
                if(wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minColumn = Math.min(minColumn, j);
                    maxRow = Math.max(maxRow, i);
                    maxColumn = Math.max(maxColumn, j);
                }
            }
        }
        
        return new int[]{minRow, minColumn, maxRow + 1, maxColumn + 1};
    }
}
