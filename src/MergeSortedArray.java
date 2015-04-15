/**
 * User: May
 * Date: 2015-04-15
 * Time: 14:57
 */
public class MergeSortedArray {

    public void insert(int A[], int m, int pos, int elem) {
        int i = m;
        while (i > pos) {
            A[i] = A[i-1];
            i--;
        }
        A[i] = elem;
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        //int size = m;
        while ((i < m+n) && j < n) {
            if (B[j] <= A[i]) {
                System.out.println("in if " + B[j]);
                int pos = m;
                while (pos > i) {
                    A[pos] = A[pos-1];
                    pos--;
                }
                A[pos] = B[j];
                for (int elem : A) {
                    System.out.print(elem + " ");
                }
                m++;
                i++;
                j++;
            }
            i++;
        }

        System.out.println(j);
        while (j < n) {
            insert(A, m, m, B[j]);
            m++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = {2,4,6};
        for (int i = 0; i < 5; i++) {
            a[i] = i+1;
        }
        MergeSortedArray test = new MergeSortedArray();
        test.merge(a, 5, b, 3);
        for (int i = 0; i < 9; i++) {
            System.out.println("a[i]:" + a[i]);
        }

    }
}
