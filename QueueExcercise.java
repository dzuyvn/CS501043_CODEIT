import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class QueueExercise {
    public static int[] queue = new int[10000];
    public static int L, R;

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileInputStream("in.txt"));
        Scanner sc = new Scanner(System.in);
        L = 0;
        R = -1;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            List<String> arg = Arrays.asList(line.split(" "));
            
            if (arg.get(0).equals("Add")) {
                for (int i = 1; i < arg.size(); i++)
                    queue[++R] = Integer.parseInt(arg.get(i));
                
                System.out.print("Item added: ");
                displayQueue();
                continue;
            }

            if (arg.get(0).equals("Query")) {
                boolean not_met = false;

                for (int i = 1; i < arg.size(); i++) {
                    int x = Integer.parseInt(arg.get(i));
                    boolean done = false;
                    while (L <= R) {
                        int tmp = queue[L++];
                        if (x == tmp) {
                            done = true;
                            break;
                        }
                    }

                    if (done == false) {
                        System.out.println("Query not met: []");
                        not_met = true;
                        break;
                    }
                }

                if (not_met) continue;
                System.out.print("Query met: ");
                displayQueue();
                continue;
            }
        }
    }

    public static void displayQueue() {
        System.out.print("[");
        for (int i = L; i < R; i++) {
            System.out.print(queue[i] + ", ");
        }
        System.out.println(queue[R] + "]");
    }
}