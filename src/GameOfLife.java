import java.util.HashMap;
import java.util.Map;

public class GameOfLife {

    public int get(int i, int j, int[][]board, Map<Integer, Map<Integer, Integer>> map){

        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){

            if(map.containsKey(i) && map.get(i).containsKey(j))
                return map.get(i).get(j);
            return board[i][j];
        }
        return 0;
    }

    public int getStatus(int currentStatus, int sum){
        switch (currentStatus){
            case 0: return sum == 3 ? 1 : 0;
            case 1: return sum < 2 || sum > 3 ? 0 : 1;
        }
        return -1;
    }

    public void gameOfLife(int[][]board){
        int iCoord [] = {-1 , 0, 1};
        int jCoord [] = {-1 , 0, 1};
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                int sum = 0;

                for(int iC = 0; iC < iCoord.length; iC++)
                    for(int jC = 0; jC < jCoord.length; jC++){
                        int newI = i + iCoord[iC];
                        int newJ = j + jCoord[jC];

                        if(newI != i || newJ != j)
                            sum += get(newI, newJ, board, map);
                    }
                map.computeIfAbsent(i, HashMap::new).put(j, board[i][j]);
                board[i][j]  = getStatus(board[i][j], sum);
            }
    }

    public static void main(String args[]){
        int board[][] = {
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(board);

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
