package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

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
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - This method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }
}
