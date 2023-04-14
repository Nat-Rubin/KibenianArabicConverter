package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import lombok.Getter;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Kibenian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/31/2023
 */
public class KibenianArabicConverter {

    // A string that holds the number (Kibenian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the KibenianArabic class that takes a string. The string should contain a valid
     * Kibenian or Arabic numeral. See the assignment instructions for what constitutes a correct input
     * and what exceptions should be raised.
     *
     * @param number A string that represents either a Kibenian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Kibenian number system.
     * @throws MalformedNumberException Thrown if the value is an Kibenian number that does not conform
     * to the rules of the Kibenian number system or any other error in Arabic number input.
     */
    public KibenianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {



        // TODO check to see if the number is valid, then set it equal to the string
        try {
           double arabicNum = Double.parseDouble(number);
           if (arabicNum != Math.floor(arabicNum)) {
               throw new MalformedNumberException("Double " + arabicNum + " not accepted");
           }
           if (arabicNum > 215999 || arabicNum < 1) {
               throw new ValueOutOfBoundsException("Double "+ arabicNum+" not accepted");
           }
           if ((int) number.charAt(0) == 0) {
               throw new MalformedNumberException("Number " + arabicNum + " contains at least one leading 0");
           }


        } catch (Exception e) {
            for (int i = 0; i < number.length(); i++) {
                if (Character.isLowerCase(number.charAt(i))) {
                    throw new MalformedNumberException(number +" has lowercase hence is not Kibenian");
                }
                if (number.contains(" ")) {
                    throw new MalformedNumberException(number + " contains spaces");
                }
            }

            char prev = number.charAt(0);
            if (prev == '_') throw new MalformedNumberException(number + " starts with '_'");

            if (number.length() > 1) {
                char current;
                int totalUnder = 0;
                int totalLs = 0;
                int totalXs = 0;
                int totalVs = 0;
                int totalIs = 0;
                int total = 0;

                kibNum prevKibNum;
                kibNum currentKibNum;

                switch (prev) {
                    case ('L'):
                        totalLs++;
                        prevKibNum = new kibNum('L');
                        break;
                    case ('X'):
                        totalXs++;
                        prevKibNum = new kibNum('X');
                        break;
                    case ('V'):
                        totalVs++;
                        prevKibNum = new kibNum('V');
                        break;
                    case ('I'):
                        totalIs++;
                        prevKibNum = new kibNum('I');
                        break;
                    default:
                        totalUnder++;
                        prevKibNum = new kibNum('_');
                        break;
                }



                for (int i = 1; i < number.length(); i++) {
                    prev = number.charAt(i-1);
                    current = number.charAt(i);

                    switch (current) {
                        case ('L'):
                            totalLs++;
                            currentKibNum = new kibNum('L');
                            break;
                        case ('X'):
                            totalXs++;
                            currentKibNum = new kibNum('X');
                            break;
                        case ('V'):
                            totalVs++;
                            currentKibNum = new kibNum('V');
                            break;
                        case ('I'):
                            totalIs++;
                            currentKibNum = new kibNum('I');
                            break;
                        default:
                            totalUnder++;
                            currentKibNum = new kibNum('_');
                            totalLs = 0;
                            totalXs = 0;
                            totalVs = 0;
                            totalIs = 0;
                            break;
                    }

                    if (totalLs > 1) {
                        throw new MalformedNumberException("Only 1 L allowed per group");
                    }
                     else if(totalXs>4){
                         throw new MalformedNumberException("Too many Xs in a row");
                    }
                    else if (totalVs > 1) {
                        throw new MalformedNumberException("Only 1 V allowed per group");
                    }
                    else if (totalIs > 4) {
                        throw new MalformedNumberException("Too many Is in a row");
                    }
                    else if (totalUnder > 2) {
                        throw new MalformedNumberException("Only two underscores allowed");
                    }

                    if (prevKibNum.kib == 'X' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    }
                    else if (prevKibNum.kib =='L'&& (currentKibNum.value>prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    }
                    else if (prevKibNum.kib =='V'&& (currentKibNum.value>prevKibNum.value)){
                        throw new MalformedNumberException("Bad number");
                    }
                    else if (prevKibNum.kib == 'I' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    } else {

                    }
                    prevKibNum = currentKibNum;
                }
            }


        }
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        try {
            int Integer.
        }
        return 1;
    }

    /**
     * Converts the number to an Kibenian numeral or returns the current value if it is already in the Kibenian form.
     *
     * @return A Kibenian value
     */
    public String toKibenian() {
        // TODO Fill in the method's body
        try{

        }
        return "I";
    }

    private class kibNum {
        private char kib;
        @Getter
        private int value;

        public kibNum(char kib) {
            this.kib = kib;
            switch (kib){
                case('L'):
                    this.value = 50;
                    break;
                case('X'):
                    this.value = 10;
                    break;
                case('V'):
                    this.value = 5;
                    break;
                case('I'):
                    this.value = 1;
                    break;
                default:
                    this.value = 0;
            }
        }
    }

}
