import java.util.Arrays;

public class MergeSort2 {

    public static void merge(int[] a, int p, int q, int r) {
        int[] tmp = Arrays.copyOf(a, a.length);
        int index_1 = p;
        int index_2 = q + 1;
        for (int i = 0; i < r - p + 1; i++) {
            if (index_1 <= q && index_2 <= r) {
                a[i+p] = tmp[index_1] < tmp[index_2] ? tmp[index_1++] : tmp[index_2++];
            } else if (index_1 <= q) {
                a[i+p] = tmp[index_1++];
            } else {
                a[i+p] = tmp[index_2++];
            }
        }
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public static void main(String[] args) {
        int[] a = {19, 7, 6, 15, 2, 6, 2, 4, 8, 16};
        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
