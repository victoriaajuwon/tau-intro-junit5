package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

    @BeforeAll
    void beforeAll(){
        //can be used to set up browser
        System.out.println("--This is the before all method");
    }

    @BeforeEach
    void beforeEach(){
        //can be used to login
        System.out.println("----This is the before each method");
    }

    @AfterAll
    void afterAll(){
        //can be used to tear down
        System.out.println("--This is the after all method");
    }

    @AfterEach
    void afterEach(){
        //can be used to logout
        System.out.println("----This is the after each method");
    }

    @Test
    @Order(2)
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - This method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }

    @Test
    @Order(1)
    void thirdTest(){
        System.out.println("This is the third test");
    }
}
