/**
 * User: May
 * Date: 2015-03-02
 * Time: 14:37
 */
public class LongestValidParenthese {

    //使用堆栈的思想，没有完成

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int length = 0;
        int left= 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                left ++;
            } else if (left > 1) {
                length += 2;
            } else if (left == 1) {
                left --;

            }else if (left == 0) {
                left --;
                maxLength = length + maxLength;
                length = 0;
            }
            if ( length > maxLength) {
                maxLength = length;
            }

            if (left < 0) {
                length = 0;
                left = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParenthese lvp = new LongestValidParenthese();
        int length = lvp.longestValidParentheses("()(()");
        System.out.println(length);
    }
}
