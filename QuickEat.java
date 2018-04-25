import java.util.*;
import java.io.*;
import java.lang.*;

public class QuickEat {
    public static final int N = 2500;

    public static void main(String[] args) throws IOException {
        int n;
        String[] dishName = new String[N];
        //Scanner sc = new Scanner(new FileInputStream("in.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            dishName[i] = sc.nextLine();
        }
        
        int[] L = new int[N];
        int[] R = new int[N];
        int[][] orderQueue = new int[N][N];

        int k = sc.nextInt();
        for (int i = 0; i < N; i++) {
            L[i] = 1;
            R[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            String cmd = sc.next();

            if (cmd.equals("Order")) {
                int tag = sc.nextInt();
                int d = sc.nextInt();

                for (int j = 0; j < d; j++) {
                    int x = sc.nextInt();
                    orderQueue[x][++R[x]] = tag;
                }
                continue;
            }

            if (cmd.equals("Ready")) {
                int x = sc.nextInt();
                if (L[x] > R[x]) {
                    System.out.println("Throw away " + dishName[x] + ".");
                    continue;
                }

                System.out.println(dishName[x] + " ready to be served to Tag " + orderQueue[x][L[x]++] + ".");
                continue;
            }
        } 
    }
}