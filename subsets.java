import java.util.Scanner;

public class subsets {
    static int c = 0;
    static int w[] = new int[10];
    static int x[] = new int[10];
    static int n, d, sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        n = in.nextInt();

        System.out.println("Enter the elements in increasing order:");
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }

        System.out.println("Enter the value of d:");
        d = in.nextInt();

        for (int i = 0; i < n; i++) {
            sum = sum + w[i];
        }

        System.out.println("SUM=" + sum);

        if (sum < d || w[0] > d) {
            System.out.println("Subset is not possible!");
            System.exit(0);
        }

        subset(0, 0, sum);

        if (c == 0) {
            System.out.println("Subset is not possible!");
        }
    }

    static void subset(int wsf, int k, int trw) {
        int i;
        x[k] = 1;

        if (wsf + w[k] == d) {
            System.out.println("Subset solution = " + (++c));
            for (i = 0; i <= k; i++) {
                if (x[i] == 1) {
                    System.out.println(w[i]);
                }
            }
            return;
        }

        if (k + 1 < n && wsf + w[k] + w[k + 1] <= d) {
            subset(wsf + w[k], k + 1, trw - w[k]);
        }

        if (k + 1 < n && (wsf + trw - w[k] >= d) && (wsf + w[k + 1] <= d)) {
            x[k] = 0;
            subset(wsf, k + 1, trw - w[k]);
        }
    }
}
