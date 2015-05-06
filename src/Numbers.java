import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * User: May
 * Date: 2015-04-24
 * Time: 19:57
 */
class Tuple {
    private int i;
    private int j;

    public Tuple(int i, int j) {
        this.i = i;
        this.j = j;
    }

    int getI() {
        return i;
    }

    int getJ() {
        return j;
    }
}

public class Numbers {
    private static Map<Integer,Tuple> plate = new HashMap<Integer, Tuple>();
    private  static int InValid = -1;

    int InValid() {
        return InValid;
    }

    void initPlate() {
        plate.put(1,new Tuple(0,0));
        plate.put(2, new Tuple(0,1));
        plate.put(3, new Tuple(0,2));
        plate.put(4, new Tuple(1,0));
        plate.put(5, new Tuple(1,1));
        plate.put(6, new Tuple(1,2));
        plate.put(7, new Tuple(2,0));
        plate.put(8, new Tuple(2,1));
        plate.put(9, new Tuple(2,2));
        plate.put(0, new Tuple(3,1));
    }

    int findMinOnPlate(int n) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        while (n > 0) {
            numList.add(n%10);
            n /= 10;
        }
        for (int i = 1; i < numList.size(); i++) {
            Tuple fir = new Tuple(plate.get(numList.get(i)).getI(),plate.get(numList.get(i-1)).getJ());
            Tuple sec = new Tuple(plate.get(numList.get(i)).getI(),plate.get(numList.get(i-1)).getJ());
            if (fir.getI() < sec.getI() || fir.getJ() < sec.getJ()) {
                return InValid;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int num = 0;

        if (in.hasNext()) {
            num = in.nextInt();
        }

        for (int i = 0; i < num; i++) {
            numbers.add(in.nextInt());
        }

        Numbers test = new Numbers();
        test.initPlate();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int index = 0; index < numbers.size(); index++) {
            int val = numbers.get(index);
            while (test.findMinOnPlate(numbers.get(index)) == test.InValid()) {
                val--;
            }
            result.add(index,val);
        }

        for (int elem : result) {
            System.out.println(elem);
        }


    }
}
