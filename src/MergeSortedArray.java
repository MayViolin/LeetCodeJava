/**
 * User: May
 * Date: 2015-04-15
 * Time: 14:57
 */
public class MergeSortedArray {

    public void insert(int A[], int m, int pos, int elem) {
        int i = m-1;
        while (i >= pos) {
            A[i+1] = A[i];
            i--;
        }
        A[i+1] = elem;
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        int size = m;

        while (i < size && j < n) {
            if (B[j] < A[i]) {
                insert(A, size, i, B[j]);
                size++;
                i++;
                j++;
            } else {
                i++;
            }
        }

        while (j < n) {
            insert(A, size, i, B[j]);
            size++;
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = {-1,0,2,3,5,6};
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        MergeSortedArray test = new MergeSortedArray();
        test.merge(a, 3, b, 6);
        for (int i = 0; i < 9; i++) {
            System.out.println("a[i]:" + a[i]);
        }

    }
}
