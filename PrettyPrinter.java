import java.util.*;

public class PrettyPrinter {
    public static void main(String[] args) {
        System.out.println("Enter a line below: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        str = str.replaceAll("\\s+\\s+"," ");
        System.out.println("Pretty-printed line: ");
        System.out.print("|" + str + "|");
    }
}