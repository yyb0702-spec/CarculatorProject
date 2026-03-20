package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        int num1 =0;
        int num2 =0;
        String ea;

        System.out.println("계산기");
        while(bool) {
            try {
                System.out.println("첫번째 정수를 입력해주세요 : ");
                num1 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요");
                sc.nextLine();
                continue;
            }

            System.out.println("기호를 입력해주세요 (+,-,*,/) : ");
            ea = sc.next();
            if (!(ea.equals("+") || ea.equals("-") || ea.equals("*") || ea.equals("/")))
            {
                System.out.println("알맞는 기호를 입력해주세요");
                continue;
            }

                try {
                    System.out.println("두번째 정수를 입력해주세요 : ");

                    num2 = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("정수를 입력해주세요");
                    sc.nextLine();
                    continue;
                }

            if (num1 < 0 || num2 < 0) {
                System.out.println("양의정수를 입력해주세요");
                continue;
            } else {

                int numbox = 0;
                sc.nextLine();

                switch (ea) {
                    case "+":
                        numbox = num1 + num2;
                        System.out.println("결과값은 = " + numbox);
                        break;
                    case "-":
                        numbox = num1 - num2;
                        System.out.println("결과값은 = " + numbox);
                        break;
                    case "*":
                        numbox = num1 * num2;
                        System.out.println("결과값은 = " + numbox);
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("0 을 나눌수 없습니다");
                        } else {
                            numbox = num1 / num2;
                            System.out.println(numbox);
                            break;
                        }

                        System.out.println("결과값은 : " + numbox);
                }
                System.out.println("종료하시려면 exit를 입력해주세요");
                String exit = sc.nextLine();
                if (exit.equals("exit")) {
                    System.out.println("계산기를 종료합니다");
                    bool = false;
                }
            }
        }



    }
}
