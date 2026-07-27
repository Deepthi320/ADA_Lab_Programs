import java.util.Scanner;

class TopoSort {

    int n;
    int a[][];
    int v[], res[], m;

    void tsort() {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        n = s.nextInt();

        a = new int[n][n];

        System.out.println("Enter the Adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = s.nextInt();

        v = new int[n];
        res = new int[n];

        for (int i = 0; i < n; i++)
            v[i] = 0;

        m = 0;

        for (int k = 0; k < n; k++) {
            if (v[k] == 0)
                dfs(k);
        }

        System.out.print("Topological Sort is:");
        for (int i = n - 1; i >= 0; i--)
            System.out.print(res[i] + " ");
    }

    void dfs(int k) {

        v[k] = 1;

        for (int u = 0; u < n; u++) {
            if (v[u] != 1 && a[k][u] == 1)
                dfs(u);
        }

        res[m++] = k;
    }
}

public class TopoSortDemo {

    public static void main(String args[]) {

        TopoSort t = new TopoSort();
        t.tsort();
    }
}
