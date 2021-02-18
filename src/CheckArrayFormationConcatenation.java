import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckArrayFormationConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // index
        for(int i = 0; i < pieces.length; i++)
            for(int j = 0; j < pieces[i].length; j++)
                map.put(pieces[i][j], Arrays.stream(pieces[i]).boxed().collect(Collectors.toList()));

        for(int i = 0; i < arr.length; i++){
            List<Integer> piece = map.get(arr[i]);

            if(piece == null || arr.length - i < piece.size()) return false;

            for (int j = 0; j < piece.size(); j++, i++)
                if (arr[i] != piece.get(j)) return false;
            i--;
        }
        return true;
    }

    public static void main(String args[]){
        CheckArrayFormationConcatenation checkArrayFormationConcatenation = new CheckArrayFormationConcatenation();
        int arr[] = {1,3,5,7};
        int pieces[][] = {{2,4,6,8}};
        System.out.println(checkArrayFormationConcatenation.canFormArray(arr, pieces));
    }
}
