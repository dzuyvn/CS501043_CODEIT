import java.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class WebBrowser {
    public static final String backstep = "BACKWARD";
    public static final String forwardstep = "FORWARD";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> lastURL = new Stack<String>();
        Stack<String> forwardURL = new Stack<String>();

        while (sc.hasNextLine()) {
            String cmd = sc.next();
            sc.nextLine();

            if (cmd.equals(backstep)) {
                if (lastURL.size() > 1) {
                    String url = lastURL.peek();
                    lastURL.pop();
                    forwardURL.push(url);
                }
                continue;
            }

            if (cmd.equals(forwardstep)) {
                if (!forwardURL.isEmpty()) {
                    String url = forwardURL.peek();
                    forwardURL.pop();
                    lastURL.push(url);
                }
                continue;
            }

            if (cmd.equals("HVD")) break;
            lastURL.push(cmd);
            forwardURL.clear();
        }

        if (lastURL.isEmpty()) {
            System.out.println("Browsing history is empty.");
            return;
        }

        Vector<String> v = new Vector<String>();
        while (!lastURL.isEmpty()) {
            String url = lastURL.peek();
            v.add(0, url);
            lastURL.pop();
        }

        String currentSite = v.lastElement();
        while (!forwardURL.isEmpty()) {
            String url = forwardURL.peek();
            v.addElement(url);
            forwardURL.pop();
        }

        if (v.isEmpty()) {
            System.out.println("Browsing history is empty.");
            return;
        }

        System.out.println("Browsing History:");
        for (String i : v)
            System.out.println(i);
        System.out.println("Current Page:");
        System.out.println(currentSite);
    }
}