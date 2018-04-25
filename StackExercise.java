import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class StackExercise {
    public static int[] stack = new int[10000];
    public static int top;

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileInputStream("in.txt"));
        Scanner sc = new Scanner(System.in);
        top = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            List<String> arg = Arrays.asList(line.split(" "));
            
            if (arg.get(0).equals("Add")) {
                for (int i = 1; i < arg.size(); i++)
                    stack[++top] = Integer.parseInt(arg.get(i));
                
                System.out.print("Items added: ");
                displayStack();
                continue;
            }

            if (arg.get(0).equals("Query")) {
                boolean not_met = false;

                for (int i = 1; i < arg.size(); i++) {
                    int x = Integer.parseInt(arg.get(i));
                    boolean done = false;
                    while (top > 0) {
                        int tmp = stack[top--];
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
                displayStack();
                continue;
            }
        }
    }

    public static void displayStack() {
        System.out.print("[");
        for (int i = top; i > 1; i--) {
            System.out.print(stack[i] + ", ");
        }
        System.out.println(stack[1] + "]");
    }
}