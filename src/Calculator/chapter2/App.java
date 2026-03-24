package Calculator.chapter2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int num1;
        int num2;
        String ea;

        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        boolean fix = true;
        while (fix) {
            System.out.println("========계산기========");
            System.out.println("1.계산하기");
            System.out.println("2.계산기록확인");
            System.out.println("3.마지막기록삭제");
            System.out.println("4.종료하기");
//        System.out.println("");

            int menual = sc.nextInt();
////코드를 자주자주써보고,TIL
            boolean bool = true;
            switch (menual) {
                case 1:
                    while (bool) {
                        try {
                            System.out.println("첫번째 정수를 입력해주세요 : ");
                            num1 = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("정수를 입력해주세요");
                            sc.nextLine();//버퍼제거
                            continue; //처음으로
                        }
                        System.out.println("기호를 입력해주세요 (+,-,*,/) : ");
                        ea = sc.next();
                        if (!(ea.equals("+") || ea.equals("-") || ea.equals("*") || ea.equals("/"))) {
                            System.out.println("알맞는 기호를 입력해주세요");
                            continue;//처음으로
                        }
                        try {
                            System.out.println("두번째 정수를 입력해주세요 : ");
                            num2 = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("정수를 입력해주세요");
                            sc.nextLine();//버퍼제거
                            continue; //처음으로
                        }
                        if (num1 < 0 || num2 < 0) {
                            System.out.println("양의정수를 입력해주세요");
                            continue;
                        } else {

                            int setresult = cal.calculator(num1,ea,num2);
                            cal.setResult(setresult);
                            int getresult = cal.getResult();
                            System.out.println("결과값은 = " + getresult);


                            sc.nextLine();//버퍼 제거
                            System.out.println("종료하시려면 exit를 입력해주세요");
                            String exit = sc.nextLine();
                            if (exit.equals("exit")) {
                                System.out.println("계산기를 종료합니다");
                                bool = false;
                            }
                        }
                    }
                    break;
                case 2:
                    sc.nextLine();
                    cal.getResultList();
                    System.out.println("엔터를 누르면 메뉴로 돌아갑니다");
                    sc.nextLine();
                    break;
                case 3:
                    sc.nextLine();
                    cal.removeResult();
                    System.out.println("엔터를 누르면 메뉴로 돌아갑니다");
                    sc.nextLine();
                    break;
                case 4:
                    fix = false;
            }
        }
    }
}