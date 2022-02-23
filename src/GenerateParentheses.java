import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList();
        dp(n,0,0, sb, res);
        return res;
    }

    public void dp(int n, int op, int cl, StringBuilder parens, List<String> res) {
        if (n == op && n == cl) {
            res.add(parens.toString());
            return;
        }
        if (op < n) {
            parens.append("(");
            dp(n, op+1, cl, parens, res);
            parens.setLength(parens.length()-1);
        }
        if (cl < op) {
            parens.append(")");
            dp(n, op, cl+1, parens, res);
            parens.setLength(parens.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GenerateParentheses gc = new GenerateParentheses();
        System.out.print(gc.generateParenthesis(n));
    }
}
