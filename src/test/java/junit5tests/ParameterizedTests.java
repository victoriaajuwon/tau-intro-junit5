package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    //using Value Source Method
    @ParameterizedTest(name ="Run: {index} - value: {arguments}") //used to improve console display
    @ValueSource(ints = {1,5,7})
    void intValues(int theParam){
        System.out.println("theParam = "+ theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource //used to pass in null and empty values for the string parameter
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }

    //Using CSV Source method: It is a useful method when we want to pass several constant value to our test method.
    @ParameterizedTest
    @CsvSource(value = {"Clark, Kent", "Diane, King", "Barry, Allen"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Clark,42,true", "Diane,30,false", "Barry,25,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"Superman,'Clark,Kent'", "Wonder woman,'Diane,King'"})
    void csvSource_StringWithComma(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Clark?Kent", "Diane?King"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    //Using  CSV File source method:
    //using one file
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    //using multiple files
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv","src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_MultipleFileStringDoubleIntStringString(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }
    //using special delimiter
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    //using Method Source:
    @ParameterizedTest
    @MethodSource(value = "sourceString") // the value here is the name of the method that will give us the value to use in this method source
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1) {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    //method that will provide the value
    List<String> sourceString(){
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    Stream<String> sourceStringAsStream(){
        //processing
        return Stream.of("beetroot", "apple", "pear");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("carrot", 4.5), arguments(
                        "cabbage", 7.8));
    }
}
