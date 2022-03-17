import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainSolution {
    final static String ROMAN_NUMERAL_REGEX = "[iIvVxXlLcCdDmM]*";

    final static Map<Character, Integer> ROMAN_VALUES = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] arg) {

        System.out.println("\n<=-- Roman Numeral Converter (type 'stop' to stop) --=>\n");

        while (true) {
            System.out.print("Please enter a Roman Numeral ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (Objects.equals(input, "stop")) break;

            // RomanNumeralToInt expects correctly formed roman numeral
            if(Pattern.compile(ROMAN_NUMERAL_REGEX).matcher(input).matches()) {
                System.out.println("You converted the Roman Numeral " + input + " to the number " + RomanNumeralToInt(input));
            } else {
                System.out.println(input + " , this input is in an invalid format. The input should only contain these (I,V,X,L,C,D,M) characters, please try again");
            }
        }
    }

    /**
     * Converts a roman numeral string (e.g. VII) into an Integer value representing its number (e.g. 8).
     * <p>
     * The solution steps through each character from the roman numeral string representation with i
     * as an iterator.
     * It checks if the next value (i+1) is greater than the current value (i). (TRUE / FALSE)
     * If this is TRUE then we have encountered a case like IV (4) or (IX) 9 ->
     * Therefore subtract current from the next and add that to the running total, then skip the next
     * character from the iteration as its value has been accounted for.
     * If this is FALSE then add the value assigned to the numeral key in the ROMANS_KEY lookup map.
     *
     * @param romanNumeral  The string representation of the roman numeral
     * @return              <code>int</code> The integer number representation of the string roman numeral.
     */
    public static int RomanNumeralToInt(String romanNumeral) {

        int runningTotal=0;
        String romanNumeralUpper = romanNumeral.toUpperCase();

        for (int i = 0; i < romanNumeralUpper.length(); i++){
            Character currentNumeral = romanNumeralUpper.charAt(i);
            Character nextNumeral = (i < romanNumeralUpper.length()-1) ? romanNumeralUpper.charAt(i+1) : null;

            if ((nextNumeral != null) && (ROMAN_VALUES.get(currentNumeral) < ROMAN_VALUES.get(nextNumeral))){
                // add the subtraction to the running total
                runningTotal = runningTotal + (ROMAN_VALUES.get(nextNumeral) - ROMAN_VALUES.get(currentNumeral));
                i++;    // Skip to next char requiring valuation (next i+2 after next i+1)
            } else {
                runningTotal = runningTotal + ROMAN_VALUES.get(currentNumeral); // simply add value from the key
            }
        }

        return runningTotal;

    }
}

