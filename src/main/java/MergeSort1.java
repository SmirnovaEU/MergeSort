import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] a = {8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43};
        a = sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] sort(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int q = a.length / 2;
        return merge(
                sort(Arrays.copyOfRange(a, 0, q)),
                sort(Arrays.copyOfRange(a, q, a.length)));
    }

    private static int[] merge(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int len = n + m;
        int p = 0;
        int q = 0;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (p < n && q < m) {
                result[i] = a1[p] < a2[q] ? a1[p++] : a2[q++];
            } else if (p < n) {
                result[i] = a1[p++];
            } else {
                result[i] = a2[q++];
            }
        }
        return result;
    }
}
