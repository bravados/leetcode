import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmaller {

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>(Collections.nCopies(nums.length, 0));
        List<Integer> bst = new ArrayList<>();

        for(int i = nums.length - 1; i >= 0; i--){
            int begin = 0, end = bst.size();

            while(begin < end){
                int mid = (begin + end) / 2;

                if(nums[i] > bst.get(mid))
                    begin = mid + 1;
                else
                    end = mid;
            }
            bst.add(begin, nums[i]);
            count.set(i, begin);
        }
        return count;
    }

    public static void main(String args[]){
        countSmaller(new int []{5, 4, 3, 2, 1});
    }
}
