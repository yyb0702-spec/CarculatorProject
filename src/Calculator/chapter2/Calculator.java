package Calculator.chapter2;

import java.util.ArrayList;

public class Calculator {
//속

//    private int num1;
//    private String ea;
//    private int num2;

    private int result;

    private ArrayList<String> resultList = new ArrayList<String>();
//생

//    public Calculator(int num1, String ea, int num2)
//    {this.num1 = num1;this.ea = ea; this.num2 = num2;}

    public int calculator(int num1, String ea, int num2) {

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
                System.out.println("잘못된 연산자입니다");
                return 0;
        }

        resultList.add(num1 + "" + ea + "" + num2 + "=" + result);
        return result;
    }
//기

    public void getResultList(){

        if(resultList.isEmpty()){
            System.out.println("계산내역이 없습니다");
        }
        for (String carlist : resultList) {
            System.out.println(carlist);
        }
    }
    public void removeResult(){
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
