package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TaggedTestClass {

    @BeforeAll
    static void beforeAll(){
        //can be used to set up browser
        System.out.println("--This is the before all method");
    }

    @BeforeEach
    void beforeEach(){
        //can be used to login
        System.out.println("----This is the before each method");
    }

    @AfterAll
    static void afterAll(){
        //can be used to tear down
        System.out.println("--This is the after all method");
    }

    @AfterEach
    void afterEach(){
        //can be used to logout
        System.out.println("----This is the after each method");
    }

    @Test
    @Tag("sanity")
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234 - TC12 - This method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod(){
        System.out.println("This is a third test method");
    }

    //using Value Source Method
    @Tag("acceptance")
    @ParameterizedTest(name ="Run: {index} - value: {arguments}") //used to improve console display
    @ValueSource(ints = {1,5,7})
    void intValues(int theParam){
        System.out.println("theParam = "+ theParam);
    }

}
