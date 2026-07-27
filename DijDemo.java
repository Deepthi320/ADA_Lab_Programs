import java.util.*;

class Dijkstra {
    int n, s, v[], c[][], dist[], p[];

    void read() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of vertices ....:");
        n = scr.nextInt();
        c = new int[n + 1][n + 1];

        System.out.println("Enter the adjacency matrix.....:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = scr.nextInt();
            }
        }

        System.out.println("Enter the source vertex.....:");
        s = scr.nextInt();
    }

    void dijAlg() {
        v = new int[n + 1];
        dist = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = 0;
            dist[i] = c[s][i];
            p[i] = s;
        }

        v[s] = 1;
        dist[s] = 0;
        p[s] = 0;

        int u = 0;

        for (int i = 2; i <= n; i++) {
            int min = 999;

            for (int j = 1; j <= n; j++) {
                if (v[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            v[u] = 1;

            for (int w = 1; w <= n; w++) {
                if (v[w] == 0 && dist[w] > dist[u] + c[u][w]) {
                    dist[w] = dist[u] + c[u][w];
                    p[w] = u;
                }
            }
        }
    }

    void path(int s, int i) {
        if (p[i] != s) {
            path(s, p[i]);
        }
        System.out.print("->" + i);
    }
}

public class DijDemo {
    public static void main(String[] args) {

        int i;
        Dijkstra d = new Dijkstra();

        d.read();
        d.dijAlg();

        System.out.println("The shortest path");

        for (i = 1; i <= d.n; i++) {
            if (i != d.s) {
                System.out.print(d.s);
                d.path(d.s, i);
                System.out.println(" with distance=" + d.dist[i]);
            }
            System.out.println();
        }
    }
}
