import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainSolutionTests {

    @Test
    public void checkRomanNumeralToInt_I() {

        int expectedResult = 1;
        String s = "I";

        int actualResult =  MainSolution.RomanNumeralToInt(s);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void checkRomanNumeralToInt_II() {

        int expectedResult = 2;
        String s = "II";

        int actualResult =  MainSolution.RomanNumeralToInt(s);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void checkRomanNumeralToInt_IV() {

        int expectedResult = 4;
        String s = "IV";

        int actualResult =  MainSolution.RomanNumeralToInt(s);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void checkRomanNumeralToInt_IX() {

        int expectedResult = 9;
        String s = "IX";

        int actualResult =  MainSolution.RomanNumeralToInt(s);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void checkRomanNumeralToInt_VIII() {

        int expectedResult = 8;
        String s = "VIII";

        int actualResult =  MainSolution.RomanNumeralToInt(s);
        assertEquals(expectedResult, actualResult);

    }


}
