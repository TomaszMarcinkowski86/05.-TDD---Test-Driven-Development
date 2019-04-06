package foo.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {


    @ParameterizedTest(name = "Area of rectangle ({0}),({1}) sould be {2}")
    @CsvSource({
            "1, 2, 2",
            "5, 3, 15"
    })
    void areaOfRectangle(int a, int b, int expextedArea){
        Rectangle rectangle=new Rectangle(a,b);
        Assertions.assertEquals(expextedArea,rectangle.area(), "pole prostąkąta");
    }
    @ParameterizedTest(name="circumference of square({0}) should be{1}")
    @CsvSource({
            "1, 4, 10",
            "2, 8, 20"
    })
    void circumferenceOfRectangel(int a, int b, int expectedCircumference) {
        Rectangle rectangle=new Rectangle(a,b);
        assertEquals(expectedCircumference,rectangle.circumference(), "obwód prostokąta");
    }
}
