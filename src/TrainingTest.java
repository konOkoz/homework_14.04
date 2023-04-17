
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrainingTest {
    String input;
    Predicate<String> predicate;
    Function<String, String> function;

    @BeforeEach
    public void init(){
        input = "AAA bbbb dEF cDkls bBb";
    }
    @Test
    public void test_3_LowerCase(){
        String expected = "aaa bbbb def cDkls bbb";
        predicate = s -> s.length() == 3;
        function = s -> s.toLowerCase();

        assertEquals(expected,Main.training(input,predicate,function));
    }
    @Test
    public void test_4_UpperCase(){
        String expected = "AAA BBBB dEF cDkls bBb";
        predicate = s -> s.length() == 4;
        function = s -> s.toUpperCase();

        assertEquals(expected,Main.training(input,predicate,function));
    }
    @Test
    public void test_5_stars(){
        String expected = "AAA bbbb dEF ***** bBb";
        predicate = s -> s.length() == 5;
        function = s -> s="*****";

        assertEquals(expected,Main.training(input,predicate,function));
    }
}
