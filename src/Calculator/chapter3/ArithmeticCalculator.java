package Calculator.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {

//    private int num1;
//    private int num2;
//
//    private String symbol;

    private ArrayList<String> resultList = new ArrayList<String>();
    private ArrayList<Double> numlist = new ArrayList<Double>();

    private double result;

    public double calculator(T num1, String symbol, T num2) {

        for (Operation op : Operation.values()) { //values =  eum의 요소들을 순서대로 enum타입의 배열로 리턴
            if (op.getSymbol().equals(symbol)) {

                resultList.add(num1 + "" + symbol + "" + num2 + "=" + op.apply((Double) num1,(Double) num2));
                numlist.add(op.apply((Double) num1,(Double) num2));

                return op.apply((Double) num1,(Double) num2);

            }
        }
        throw new IllegalArgumentException("올바른 사측연산 기호를 입력해주세요");
    }

    public void getResultList(){

        if(resultList.isEmpty()){
            System.out.println("계산내역이 없습니다");
        }
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(i+1 + "." + resultList.get(i));
        }
    }

    public void removeResult(int deleteidx){

        resultList.remove(deleteidx - 1);
        System.out.println("계산기록이 삭제되었습니다");
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result){
        this.result = (double) result;
    }

    public void findResult() {
        List<Double> maxlist = numlist.stream()
                .filter(num -> num > this.result)
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

