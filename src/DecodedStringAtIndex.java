import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecodedStringAtIndex {

    private static String find(int K, List<String> words, List<Integer> lengths){
        int pos = K;
        char c = ' ';

        for(int i = lengths.size() - 1; i >= 0; i--){
            int previousLength = 0;

            if(i - 1 >= 0)
                previousLength = lengths.get(i - 1);

            String word = words.get(i);
            int length = previousLength + word.length();
            pos = pos % length;
            pos = pos == 0 ? length : pos;  // if rest is 0 pos is the last

            if(pos > previousLength) {
                int start = pos - previousLength;
                c = word.charAt(start - 1);
                break;
            }
        }
        return String.valueOf(c);
    }

    public static String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int accLength = 0;
        List<String> words = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();

        for(int i = 1; i <= S.length(); i++){
            char c = S.charAt(i - 1);

            if(c >= 'a' && c <= 'z'){
                accLength++;
                sb.append(c);

                if(accLength == K)
                    return String.valueOf(c);
            } else{
                String word = sb.toString();
                int digit = c - '0';
                accLength *= digit;

                if(word.isEmpty()){
                    lengths.remove(lengths.size() - 1);
                    lengths.add(accLength);
                } else {
                    words.add(word);
                    lengths.add(accLength);
                    sb = new StringBuilder();
                }

                if(K <= accLength){
                    return find(K, words, lengths);
                }
            }
        }
        return null;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int k = scanner.nextInt();
        System.out.println(decodeAtIndex(input, k));
    }
}
