/**
 * User: May
 * Date: 2015-05-07
 * Time: 17:39
 */
public class CountAndSay {

    private int[] count = {0,0,0,0,0,0,0,0,0,0};

    String sayNumber(String str) {
        int length = str.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length && j < length) {
            if (str.charAt(j) == str.charAt(i)) {
                count[str.charAt(i) - '0']++;
                j++;
            } else {
                sb.append(count[str.charAt(i) - '0']);
                sb.append(str.charAt(i));
                i = j;
            }
        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        } else {
            for (int i = 0; i < n; i++) {
                s = sayNumber(s);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(4));
    }
}
