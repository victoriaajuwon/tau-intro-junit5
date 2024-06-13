package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    //using Value Source Method
    @ParameterizedTest(name ="Run: {index} - value: {arguments}") //used to improve console display
    @ValueSource(ints = {1,5,7})
    void intValues(int theParam){
        assumeTrue(theParam > 4);
        System.out.println("theParam = "+ theParam);
    }

    //Using CSV Source method: It is a useful method when we want to pass several constant value to our test method.
    @ParameterizedTest
    @CsvSource(value = {"Clark, Kent", "Diane, King", "Barry, Allen"})
    void csvSource_StringString(String param1, String param2){
        assumeFalse(param1.equals("Clark"), "The assumption failed for the following param2: "+param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Clark,42,true", "Diane,30,false", "Barry,25,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        assumingThat(param2 > 26, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
