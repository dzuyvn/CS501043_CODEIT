import java.util.*;
import java.io.*;

public class Parser {
    public static final String[] ptags = {"<S>", "</S>", "<P>", "</P>", "<B>", "</B>", "<I>", "</I>"};
    public static final String[] stags = {"<LB>", "<PB>", "<TEXT>"};

    public static void main(String[] args) {
        Stack<String> st = new Stack<String>();
        Set<String> paired_tags = new HashSet<>(Arrays.asList(ptags));
        Set<String> single_tags = new HashSet<>(Arrays.asList(stags));

        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String keyword = sc.next();
            sc.nextLine();
            if (paired_tags.contains(keyword)) {
                if (keyword.charAt(1) == '/') {
                    String top_tags = st.peek();
                    keyword = keyword.charAt(0) + keyword.substring(2, keyword.length());

                    if (keyword.equals(top_tags)) {
                        st.pop();
                        continue;
                    } else {
                        System.out.println("Error!");
                        return;
                    }
                } else {
                    st.push(keyword);
                    continue;
                }
            }

            if (single_tags.contains(keyword)) continue;

            System.out.println("Error!");
            return;
        }

        if (st.isEmpty() == false) {
            System.out.println("Error!");
            return;
        }

        System.out.println("No Error");
    }
}