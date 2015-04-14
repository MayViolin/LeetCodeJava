import java.util.HashMap;

/**
 * User: May
 * Date: 2015-02-10
 * Time: 16:46
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length;i++) map.put(numbers[i],i+1);
        for (int j=0;j<numbers.length;j++) {
            int rest = target - numbers[j];

            if (map.containsKey(rest) && map.get(rest)!= j+1) {
                int index = map.get(rest);
                if (index>j+1) return new int[]{j+1,index};
                else return new int[]{index,j+1};
            }
        }
        return new int[0];
    }

//    public static void main(String[] args) {
//        int[] a = {-1,-2,-3,-4,-5};
//        int target = -8;
//        TwoSum ts = new TwoSum();
//        int[] r = ts.twoSum(a,target);
//        for (int e : r) {
//            System.out.println(e);
//        }
//    }

}
