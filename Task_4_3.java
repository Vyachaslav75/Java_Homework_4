import java.util.Scanner;
import java.util.Stack;

public class Task_4_3 {
    static int calc(int num1, int num2, String sign) {
        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String work = "Y";
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int num1 = 0;
        while (work.equals("Y")) {
            if (st.isEmpty()) {
                System.out.println("Введите первое число");
                num1 = Integer.parseInt(sc.nextLine());
                
            } else {
                num1 = st.peek();
                System.out.printf("Первое число  %d \n", num1);
            }
            // System.out.println("Введите первое число");
            // int num1 = Integer.parseInt(sc.nextLine()); // sc.nextInt();
            System.out.println("Введите операцию +, -, /, *");
            String sign = sc.nextLine();
            System.out.println("Введите второе число");
            int num2 = Integer.parseInt(sc.nextLine());
            result = calc(num1, num2, sign);

            System.out.printf("%d %s %d = %d\n", num1, sign, num2, result);
            System.out.println("Отменить последнюю операцию? Y / N");
            work = sc.nextLine();
            if (work.equals("Y")) {
                if (st.isEmpty()) {
                    System.out.println("Последняя операция отсутствует");
                } else {
                    result = st.pop();
                }
            }
            st.add(result);
            System.out.println("Хотите продолжить? Y / N");
            work = sc.nextLine();

        }
        sc.close();

    }

}
