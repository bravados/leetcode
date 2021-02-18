import java.util.List;

public class BurstBalloonsProblem {

    public int maxCoins(int[] nums){
        if(nums.length == 0) return 0;

        int T[][] = new int[nums.length][nums.length];

        for(int l = 1; l <= nums.length; l++)
            for(int i = 0; i <= nums.length - l; i++){
                int j = i + l - 1;

                for(int k = i; k <= j; k++){
                    int leftValue = 1;
                    int rightValue = 1;

                    if(i != 0)
                        leftValue = nums[i - 1];
                    if(j != nums.length - 1)
                        rightValue = nums[j + 1];

                    int before = 0;
                    int after = 0;

                    if(i != k)
                        before = T[i][k - 1];
                    if(j != k)
                        after = T[k + 1][j];

                    T[i][j] = Math.max(leftValue * nums[k] * rightValue + before + after, T[i][j]);
                }
            }
        return T[0][nums.length - 1];
    }

    public static void main(String args[]){
        int[] nums = {9,76,64,21,97,60,5};
        BurstBalloonsProblem problem = new BurstBalloonsProblem();
        System.out.println(problem.maxCoins(nums));
    }

}
