import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestOne {

    static class Tuple {
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    static Map<Integer, Tuple> map = null;

    static {
        map = new HashMap<Integer, Tuple>();
        map.put(1, new Tuple(0,0));
        map.put(2, new Tuple(0,1));
        map.put(3, new Tuple(0,2));
        map.put(4, new Tuple(1,0));
        map.put(5, new Tuple(1,1));
        map.put(6, new Tuple(1,2));
        map.put(7, new Tuple(2,0));
        map.put(8, new Tuple(2,1));
        map.put(9, new Tuple(2,2));
        map.put(0, new Tuple(3,1));
    }

    public static void solution(String number){
        int result[] = new int[number.length()];
        boolean pass = false;
        int rec = 9;
        for(int i=0;i<number.length();i++){
            if(pass){
                result[i]=rec;
            }else{
                if(i==0){
                    result[i]=number.charAt(i)-'0';
                }else{
                    Tuple p = map.get(result[i-1]);
                    Tuple n = map.get(Integer.parseInt(""+number.charAt(i)));
                    if(n.x>=p.x && n.y>=p.y){
                        result[i] = number.charAt(i)-'0';
                    }else if(result[i-1]<number.charAt(i)-'0'){
                        int cand = number.charAt(i)-'0'-1;
                        while(true){
                            if(isValid(result[i - 1], cand)){
                                result[i]=cand;
                                if(cand==0){rec=0;}
                                pass = true;break;
                            }
                            cand--;
                        }
                    }else if(isValid(result[i - 1], 0)){
                        pass=true;
                        rec=0;
                    }else{
                        int j=i-2;
                        for(;j>=0;j--){
                            if(result[j]!=result[j+1]){
                                break;
                            }
                        }
                        if(j<0){
                            result[0]=result[0]-1;
                            i=0;
                            pass=true;
                        }else{
                            int cand = result[j+1];
                            cand--;
                            while(true){
                                if(isValid(result[j], cand)){
                                    result[j+1]=cand;
                                    pass=true;
                                    i=j+1;
                                    break;
                                }
                                cand--;
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
        System.out.println();
    }

    public static boolean isValid(int a, int b){
        Tuple p1 = map.get(a);
        Tuple p2 = map.get(b);
        return p1.x<=p2.x && p1.y<=p2.y;
    }



    public static void main(String[] args) {
        int cases;
        Scanner scanner = new Scanner(System.in);
        cases = scanner.nextInt();
        for(int i=0;i<cases;i++){
            String number = scanner.next();
            solution(number);
        }
    }
}
