package Calculator.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {

//    private int num1;
//    private int num2;
//
//    private String symbol;

    private ArrayList<String> resultList = new ArrayList<String>(); //계산결과 저장
    private ArrayList<Double> numlist = new ArrayList<Double>(); //계산된값

    private double result;

    public double calculator(T num1, String symbol, T num2) {

        for (Operation op : Operation.values()) { //values =  eum의 요소들을 순서대로 enum타입의 배열로 리턴
            if (op.getSymbol().equals(symbol)) { //enum 객체를가져와서 getter함수로 심볼을 가져온후 비교

                resultList.add(num1 + "" + symbol + "" + num2 + "=" + op.apply((Double) num1,(Double) num2));
                numlist.add(op.apply((Double) num1,(Double) num2));

                return op.apply((Double) num1,(Double) num2);

            }
        }
        throw new IllegalArgumentException("올바른 사측연산 기호를 입력해주세요"); // 예외처리
    }

    public void getResultList(){         //계산결과 조회

        if(resultList.isEmpty()){
            System.out.println("계산내역이 없습니다");
        }
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(i+1 + "." + resultList.get(i));
        }
    }

    public void removeResult(int deleteidx){ //계산결과 삭제

        resultList.remove(deleteidx - 1);
        System.out.println("계산기록이 삭제되었습니다");
    }

    public double getResult() {
        return result;
    } //getter

    public void setResult(double result){
        this.result = (double) result;
    } //setter

    public void findResult() { //계산결과보다 더 높은값 출력하는 메소드
        List<Double> maxlist = numlist.stream()
                .filter(num -> num > this.result) //중간계산 람다식 num > this result
                .collect(Collectors.toList());
        if(maxlist.isEmpty())
        {
            System.out.println("리스트에 결과값보다 더 높은 숫자가없습니다");
        }
        else {
            System.out.println("저장된 연산결과중 더 큰값 :" + maxlist);
        }
    }
}

