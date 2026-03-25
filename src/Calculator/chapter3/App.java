package Calculator.chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        double num1;
        String ea;
        double num2;

        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator<Double> cal = new ArithmeticCalculator();

//        for(Operation op : Operation.values()){
//            System.out.println(op);
//        }
        boolean fix = true;
        while (fix) {
            System.out.println("========계산기========");
            System.out.println("1.계산하기");
            System.out.println("2.계산기록확인");
            System.out.println("3.이전기록삭제");
            System.out.println("4.종료하기");

            int menual = sc.nextInt();
            boolean bool = true;
            switch (menual) {

                case 1:

                    while (bool) {
                        try {
                            System.out.println("첫번째 숫자를 입력하세요");

                            num1 = sc.nextDouble();
                            sc.nextLine();
                        } catch (InputMismatchException e) { //예외처리
                            System.out.println("숫자를 입력해주세요");
                            sc.nextLine();//버퍼제거
                            continue; //처음으로
                        }
                        System.out.println("연산자를 입력해주세요 (+,-,*,/) : ");
                        ea = sc.next();
                        if (!(ea.equals("+") || ea.equals("-") || ea.equals("*") || ea.equals("/"))) {
                            System.out.println("알맞는 기호를 입력해주세요"); //예외처리
                            continue;//처음으로
                        }
                        try {
                            System.out.println("두번째 수를 입력하세요");

                            num2 = sc.nextDouble();
                            sc.nextLine();
                        } catch (InputMismatchException e) { //예외처리
                            System.out.println("숫자를 입력해주세요");
                            sc.nextLine();//버퍼제거
                            continue; //처음으로
                        }

                        double setresult = cal.calculator(num1, ea, num2);
                        cal.setResult(setresult);
                        double getresult = cal.getResult();

                        System.out.println("결과값은 = " + getresult);
                        cal.findResult();

//                        cal.getResultList();
//                        cal.findResult();
                        System.out.println("종료하시려면 exit를 입력해주세요");
                        String exit = sc.nextLine();
                        if (exit.equals("exit")) {
                            System.out.println("계산기를 종료합니다");
                            bool = false;
                        }
                    }
                    break;
                case 2:
                    sc.nextLine(); //버퍼비우기

                        cal.getResultList();
                        System.out.println("엔터를 누르면 메뉴로 돌아갑니다");
                        sc.nextLine();
                    break;
                case 3:
                    sc.nextLine(); //버퍼제거
                    while(true) {
                        cal.getResultList(); //조회
                        try {
                            System.out.println("삭제하고싶은 계산기록을 입력하세요 0입력시 돌아가기");
                            int delete = sc.nextInt();

                            if(delete == 0)
                            {
                                System.out.println("메뉴로돌아갑니다");
                                break;
                            }
                            cal.removeResult(delete);
                            } catch(InputMismatchException e){
                                System.out.println("숫자를 입력해주세요");
                            sc.nextLine();
                            } catch(IndexOutOfBoundsException e){
                                System.out.println("삭제 할 올바른 번호를 입력해주세요");
                            }
                        }
                    break;
//                case 4:
//                    cal.findResult();
//                    System.out.println("돌아가시려면 skip을 입력해주세요");
//                    skip = sc.nextLine();
//                    if (skip.equals("skip")) {
//                        break;
//                    }
                case 4:
                    fix = false;
            }

        }
    }
}

