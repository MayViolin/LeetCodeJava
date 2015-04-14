import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * User: May
 * Date: 2015-04-02
 * Time: 18:58
 */
public class Test {

    public static void main(String[] args) {
        int seed = 1000;
        Random r = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 100) {
            int randomNumber = r.nextInt(seed);
            if (randomNumber > 0) {
                set.add(randomNumber);
            }
        }
        for (int i=0;i<1000;i++) {
            if (!set.contains(i)) {
                System.out.println(i);
            }
        }
    }

}
