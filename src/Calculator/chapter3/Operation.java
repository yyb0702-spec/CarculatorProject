package Calculator.chapter3;


//Enum 이미 만들어놓은 객체 인스턴트화 없이 바로쓸수있음 Operation 변수 = Opreration.ADD
public enum Operation {
//    ADD("+"),
//    SUB("-"),
//    MUL("*"),
//    DIV("/");

    //    ADD((a,b) -> a+b),
//    SUB((a,b) -> a-b),
//    MUL((a,b) -> a*b),
//    DIV((a,b) -> a/b)
    ADD("+"){
        @Override
        public double apply(double num1 , double num2)
        {return num1 + num2;}
    },
    SUB("-"){
        @Override
        public double apply(double num1 , double num2){
            return num1 - num2;
        }
    },
    MUL("*"){
        @Override
        public double apply(double num1 , double num2){
            return num1 * num2;
        }
    },
    DIV("/"){
        @Override
        public double apply(double num1 , double num2){
            if (num2 == 0) {
                System.out.println("0으로 나눌수없습니다");
                return 0;
            }
            return num1 / num2;
        }
    };
//속
    private final String symbol;
//생
    Operation(String symbol)
    {
        this.symbol = symbol;
    }
//기

    public String getSymbol(){
        return symbol;
    }

    public abstract double apply(double num1, double num2); //심볼에 따라 개별적 처리가 필요하다


    //
//    public static Operation findOp(String symbol){
//        for(Operation op : Operation.values()){
//            if(op.symbol.equals(symbol)){
//                return op;
//            }
//            }


//        }
//    }


}
