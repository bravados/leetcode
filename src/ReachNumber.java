import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReachNumber {

    public int reachNumber(int target){
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);
        nodes.add(-1);

        for(int steps = 1; ; steps++){
            Queue<Integer> nextNodes = new LinkedList<>();

            while(!nodes.isEmpty()){
                Integer n = nodes.poll();

                if(target > 0 && n <= target || target < 0 && n >= target) {

                    if (n.equals(target)) return steps;

                    nextNodes.addAll(Arrays.asList(n + steps + 1, n - (steps + 1)));
                }
            }
            nodes = nextNodes;
        }
    }

    public static void main(String args[]){
        ReachNumber reachNumber = new ReachNumber();
        System.out.println(reachNumber.reachNumber(4));
    }
}
