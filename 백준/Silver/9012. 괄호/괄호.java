import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.io.*;
import java.math.*;

class Parenthesis{
    public boolean stack(String par){
        Stack<String> stack = new Stack<>(); // 스택에 괄호 넣기
        for (int i = 0; i < par.length(); i++) {
            if (par.charAt(i) == '(') {
                stack.push(par);
            } else if(par.charAt(i) == ')') { // 닫는 괄호가 들어오면
                if (stack.empty()) return false; // 짝이 되는 '('가 없음
                else{
                    stack.pop();
                }
            }
        }
        if (stack.empty()){
            return true; // 괄호의 짝이 모두 맞음
        }
        else{
            return false; // 괄호가 남아있음
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>(); // 괄호 넣기
        Parenthesis parenthesis = new Parenthesis();
        int case_n = scan.nextInt();

        for (int i = 0; i < case_n; i++) {
            String par = scan.next();

            if (parenthesis.stack(par)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}