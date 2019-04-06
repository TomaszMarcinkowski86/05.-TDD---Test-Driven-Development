package foo.bar;

import java.math.BigDecimal;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        if(b==0){
            System.out.println("nie dziel przez zero");
        }
        return a*b;
    }

    public BigDecimal divide(BigDecimal a , BigDecimal b){
        if(b.equals(0)){
            System.out.println("nie dziel przez zero");
        }
        return a.divide(b);
    }
}
