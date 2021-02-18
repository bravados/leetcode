import java.util.*;

public class BeautifulArrangement {

    private int backtrack(int index, int n, boolean [] visited){
        if(index > n) return 1;

        int count = 0;

        for(int i = 1; i <= n; i++)
            if(!visited[i - 1] && (i % index == 0 || index % i == 0)){
                visited[i - 1] = true;
                count += backtrack(index + 1, n, visited);
                visited[i - 1] = false;
            }
        return count;
    }

    public int countArrangement(int n){
        return backtrack(1, n, new boolean[n]);
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(n));
    }
}
