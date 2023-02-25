import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class Task_4_4_1 {
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static ArrayDeque<String> doPostfix(String str) {
        Stack<String> st = new Stack<>();
        ArrayDeque<String> dq = new ArrayDeque<>();
        //System.out.println(str);
        int i = 0;
        String tmpStr = "";
        while (i < str.length()) {

            //tmpStr =tmpStr + str.charAt(i);
            while (i < str.length() && !"+ - * / ( )".contains(String.valueOf(str.charAt(i)))){
                //System.out.println(tmpStr);
                tmpStr =tmpStr + str.charAt(i);
                i++;
                //System.out.println(tmpStr);
            }

            //System.out.println(tmpStr.length());
            if (tmpStr.length() == 0){
                tmpStr =tmpStr + str.charAt(i);
                i++;
            }

            //System.out.println("tmpStr= "+tmpStr);
            if (isNumeric(tmpStr)) {
                dq.add(tmpStr);
            } else if ("+ - * /".contains(tmpStr)) {
                //System.out.println(st.isEmpty());
                //System.out.println(st.peek().equals("("));
                if (st.isEmpty() || st.peek().equals("(")) {
                    st.add(tmpStr);
                } else if ("* /".contains(tmpStr) & "+ -".contains(st.peek())) {
                    st.add(tmpStr);
                } else {
                    while (!st.isEmpty() && !"(".contains(st.peek())) { //  && !"+ -".contains(st.peek())) {
                        dq.add(st.pop());
                    }
                    st.add(tmpStr);
                }

            } //else 
            if ("(".contains(tmpStr)) {
                st.add(tmpStr);
            } //else 
            if (!st.isEmpty() && ")".contains(tmpStr)) {
                while (!"(".contains(st.peek())) {
                    //System.out.println("st= " + st.peek());
                    dq.add(st.pop());
                }
                st.remove("(");
            }
            //i++;
            tmpStr="";
            //System.out.println("dq = " + dq);
            //System.out.println("st = " + st);

        }
        while (!st.isEmpty()) {
            dq.add(st.pop());
        }
        return dq;
    }

    private static int calc(int num1, int num2, String sign) {
        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    private static int calcExpression(ArrayDeque<String> dq) {
        Stack<String> st = new Stack<>();
        //ArrayDeque<String> dq = new ArrayDeque<>();
        //System.out.println(dq);
        while (dq.peek() != null) {
            if (isNumeric(dq.getFirst())) {
                st.add(dq.removeFirst());
            } else {
                int y = Integer.parseInt(st.pop());
                int x = Integer.parseInt(st.pop());
                int res = calc(x, y, dq.removeFirst());
                System.out.println(res);
                st.add(Integer.toString(res));

            }

        }
        return Integer.parseInt(st.peek());
    }

    public static void main(String[] args) {
        //Stack<String> st = new Stack<>();
        ArrayDeque<String> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение");
        String myStr = sc.nextLine();
        System.out.println(myStr);
        dq = doPostfix(myStr);
        System.out.println("doPostfix: " + dq);
        //System.out.println(st);
        int res = calcExpression(dq);

        System.out.println(res);
        sc.close();
    }
}