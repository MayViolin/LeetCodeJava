import java.util.HashMap;

/**
 * User: May
 * Date: 2015-05-06
 * Time: 16:08
 */
public class LongestSubString {

    HashMap<Character,Integer> characters = new HashMap<Character,Integer>();

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (j < s.length()) {
                Character ch = s.charAt(j);
                if (!characters.keySet().contains(ch)) {
                    characters.put(ch, j);
                    count++;
                    ++j;
                } else {
//                    characters.clear();
                    if (count > maxLength) {
                        maxLength = count;
                    }
                    count = 0;
                    i = characters.get(ch) + 1;
                    characters.clear();
                    break;
                }
            }

//            String subString = s.substring(i,j);
//            if (s.substring(j).contains(subString) && subString.length() >= maxLength) {
//                i = j + s.substring(j).indexOf(subString);
//            } else {
//                if (j < s.length()) {
//                    i = characters.get(s.charAt(j)) + 1;
//                } else {
//                    i = j;
//                }
//            }
            //characters.clear();
        }
        if (count > maxLength) {
            maxLength = count;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
        System.out.println(test.lengthOfLongestSubstring("vssbhvljkjjpegotukhvsudohdujbzbwttxcpkmztxq"));
    }
}
