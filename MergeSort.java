import java.util.Scanner;
import java.util.Random;

class MergeSortClass {

    int n;
    int a[];

    MergeSortClass(int x) {
        n = x;
        a = new int[n];
    }

    void generate() {
        Random r = new Random();

        System.out.println("Generating random numbers...");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100);
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    void merge(int a[], int low, int mid, int high) {

        int b[] = new int[high + 1];

        int h = low;
        int i = low;
        int j = mid + 1;

        while ((h <= mid) && (j <= high)) {
            if (a[h] <= a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];
        }

        while (h <= mid)
            b[i++] = a[h++];

        while (j <= high)
            b[i++] = a[j++];

        for (int k = low; k <= high; k++)
            a[k] = b[k];
    }

    void mergeSort(int a[], int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);

            merge(a, low, mid, high);
        }
    }

    void display() {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}

public class MergeSort {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of elements");
        int x = s.nextInt();

        MergeSortClass m = new MergeSortClass(x);

        m.generate();

        long start_time = System.currentTimeMillis();

        m.mergeSort(m.a, 0, m.n - 1);

        long end_time = System.currentTimeMillis();

        System.out.println("\nSorted Array:");
        m.display();

        System.out.println("\nTime taken = " + (end_time - start_time) + " Milli seconds");
    }
}
