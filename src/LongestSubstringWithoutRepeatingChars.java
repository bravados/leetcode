import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, n = s.length(), max = 0;
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else
                set.remove(s.charAt(i++));
        }
        return max;
    }

    public static void main(String args[]){
        LongestSubstringWithoutRepeatingChars longestSubstringWithoutRepeatingChars = new LongestSubstringWithoutRepeatingChars();
        System.out.println(longestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("dvdf"));
    }
}
