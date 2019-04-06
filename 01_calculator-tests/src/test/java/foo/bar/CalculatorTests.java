package foo.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test                      //test bedzie testem jak to będzie
    @DisplayName("1 + 1 = 2")
        // to będzie pokazywało w oknie niżej po lewej mamy opis.
    void addsTwoNumbers() {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        // pierwszy parametr to  to czego się spodziewamy, 2 następne to parametry dostarczone do testy
        // 3 parametrto info jak nie przejdzie.
    }

    @Test
    @DisplayName("0 +101 = 101")
    void addTwoNumbers1() {
        assertEquals(101, calculator.add(0, 101), "0+101 should equals 101");
    }

    @Test
    @DisplayName("-5 + (-2)= -7")
    void addTwoNumbers2() {
        assertEquals(-7, calculator.add(-5, -2), "-5+-2 should equals -7");
    }

    @Test
    @DisplayName("-7 + (-3)= -10")
    void addTwoNumbers3() {
        assertEquals(-10, calculator.add(-7, -3), "-7+-3 should equals -10");
    }

    @Test
    @DisplayName("10-2=9")
    void substractTwoNumber() {
        assertEquals(8, calculator.substract(10, 2), "10-2 should be 8");
    }

    @Test
    @DisplayName("0-0=0")
    void substractTwoNumbers2(){
        assertEquals(0,calculator.substract(0,0));
    }
    @Test
    @DisplayName("2-(-2)=4")
    void substractTwoNumber3(){
        assertEquals(4, calculator.substract(2,-2), "2-(-2)=4");
    }

    @Test
    @DisplayName("7*3=35")
    void multiplyTwoNumbers(){
        assertEquals(35, calculator.multiply(7,5), "7*5=35");
    }
    @Test
    @DisplayName("7*0=0")
    void multiplyTwoNumbers2(){
        assertEquals(0, calculator.multiply(7,0), "7*5=35");
    }
    @Test
    @DisplayName("5/2=2.5")
    void divideTwoNumbers(){
        assertEquals(BigDecimal.valueOf(2.5), calculator.divide(BigDecimal.valueOf(5),BigDecimal.valueOf(2)), "5/2=2.5");
    }
}

