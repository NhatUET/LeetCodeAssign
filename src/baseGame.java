import java.awt.*;
import java.util.Stack;

public class baseGame {
    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (String op : ops) {
            switch (op) {
                case "C" -> st.pop();
                case "D" -> st.add(st.peek() * 2);
                case "+" -> {
                    int prev = st.pop();
                    int s = prev + st.peek();
                    st.add(prev);
                    st.add(s);
                }
                default -> st.add(Integer.parseInt(op));
            }
        }
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] a = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(a));
    }
}
