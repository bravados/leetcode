import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsProblem {

    private static int sumPrevious(int n){
        return (int)(Math.pow(n, 2) + n) / 2;
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for(int i = 0; i < time.length; i++){
            int number = time[i] % 60;
            int complement = number == 0 ? 0 : 60 - number;
            int found = map.getOrDefault(complement, 0);

            if(complement == 0 && found > 0)
                pairs += sumPrevious(found) - sumPrevious(found - 1);
            else
                pairs += found;

            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return pairs;
    }

    public static void main(String args[]){
        int [] songs = {60, 60, 60};
        System.out.println(numPairsDivisibleBy60(songs));
    }
}
