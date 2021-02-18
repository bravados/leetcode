public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int missing = 0, i, n;

        for(i = 1; i <= arr.length && missing < k; i++)
            missing = arr[i - 1] - i;

        if(missing >= k){
            n = arr[i - 2];
            n--;

            while(missing > k){
                missing--;
                n--;
            }
        } else {
            n = arr[i - 2];

            while(missing < k){
                missing++;
                n++;
            }
        }
        return n;
    }

    public static void main(String args[]){
        KthMissingPositiveNumber kthMissingPositiveNumber = new KthMissingPositiveNumber();
        System.out.println(kthMissingPositiveNumber.findKthPositive(new int [] {2,3,4,7,11}, 6));
    }
}
