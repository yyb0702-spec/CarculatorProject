package calculator.chapter2;

import java.util.ArrayList;

public class Calculator {
//속

//    private int num1;
//    private String ea;
//    private int num2;

    private int result;

    private ArrayList<String> resultList = new ArrayList<String>(); //계산결과 리스트
//생

//    public Calculator(int num1, String ea, int num2)
//    {this.num1 = num1;this.ea = ea; this.num2 = num2;}

    public int calculate(int num1, String ea, int num2) {

        switch (ea) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("0으로 나눌수없습니다");
                    return 0;
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 사측연산 기호를 입력해주세요"); //예외처리
        }

        resultList.add(num1 + "" + ea + "" + num2 + "=" + result);
        return result;
    }
//기

    public boolean getResultList(){ //계산결과 조회

        if(resultList.isEmpty()){
            System.out.println("계산내역이 없습니다");
            return false;
        }
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(i+1 + "." + resultList.get(i));
        }
        return true;
    }
    public void removeResult(){ //마지막계산기록삭제 idx = 0
        if(resultList.isEmpty())
        {
            System.out.println("계산기록이없습니다");
            return;
        }
        resultList.remove(0);
        System.out.println("마지막 계산기록이 삭제되었습니다");
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result){
        this.result = result;
    }



}
