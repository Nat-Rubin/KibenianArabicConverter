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

       if(Pattern.matches("((\\+|-)?([0-9]+)(\\.[0-9]+)?)|((\\+|-)?\\.?[0-9]+)" ,number)) {

           for (int i = 0; i < number.length(); i++) {
               if (number.charAt(i) == '.')
                throw new MalformedNumberException("Double " + number + " not accepted");
           }

           int arabicNum = Integer.parseInt(number);

           if (arabicNum > 215999 || arabicNum < 1) {
               throw new ValueOutOfBoundsException(arabicNum + " not accepted, too big or too large");
           }

           if (number.charAt(0) == '0') {
               throw new MalformedNumberException("Number " + arabicNum + " contains at least one leading 0");
           }

       } else {
            if (number.length() == 0) {
                throw new StringIndexOutOfBoundsException("You entered an empty string!");
            }

            if(Pattern.matches("[^LXVI_]", number)) {
                throw new MalformedNumberException(number + " contains illegal characters");
            }

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

                total += prevKibNum.value;

                for (int i = 1; i < number.length(); i++) {
                    /*prev = number.charAt(i-1);
                    current = number.charAt(i);*/
                    currentKibNum = new kibNum(number.charAt(i));

                    switch (currentKibNum.kib) {
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

                    // Checks for number of each character
                    if (totalLs > 1) {
                        throw new MalformedNumberException("Only 1 L allowed per group");
                    } else if (totalXs > 4) {
                        throw new MalformedNumberException("Too many Xs in a row");
                    } else if (totalVs > 1) {
                        throw new MalformedNumberException("Only 1 V allowed per group");
                    } else if (totalIs > 4) {
                        throw new MalformedNumberException("Too many Is in a row");
                    } else if (totalUnder > 3) {
                        throw new MalformedNumberException("Only consecutive allowed");
                    }

                    // Checks for order of characters
                    if (prevKibNum.kib == 'X' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    } else if (prevKibNum.kib == 'L' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    } else if (prevKibNum.kib == 'V' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    } else if (prevKibNum.kib == 'I' && (currentKibNum.value > prevKibNum.value)) {
                        throw new MalformedNumberException("Bad number");
                    } else {

                    }

                    // Check total
                    total = total + currentKibNum.value;

                    if (total > 59) {
                        throw new MalformedNumberException("Sub group total too large");
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
        int num = 0;
            if (Pattern.matches("\\d+", number)) {
                return Integer.parseInt(number);
            }

            int subset = 0;

            kibNum current;
            for (int i = 0; i < number.length(); i++) {
                current = new kibNum(number.charAt(i));

                if (current.value != 0) {
                    // not _
                    subset += current.value;
                } else {
                    if (number.length() - i + 1 != 0) {
                        if (number.length() != i+1) {
                            if (number.charAt(i + 1) == '_') {
                                subset *= 3600;
                                i++;
                                num += subset;
                                subset = 0;
                            } else {
                                boolean exists = false;
                                for (int j = i+1; j < number.length(); j++) {
                                    if (number.charAt(j) == '_') {
                                        subset *= 3600;
                                        //i++;
                                        num += subset;
                                        subset = 0;
                                        exists = true;
                                        break;
                                    }
                                }
                                if (!exists) {
                                    subset *= 60;
                                    num += subset;
                                    subset = 0;
                                }
                            }
                        } else {
                            subset *= 60;
                            num += subset;
                            subset = 0;
                        }
                    } else {
                        subset *= 60;
                        num += subset;
                        subset = 0;
                    }
                }
            }

            num += subset;


        return num;
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
    }

    private StringBuilder calculateSubSection(int num) {
        StringBuilder subSection = new StringBuilder();
        if (num / 50 == 1) {
            subSection.append('L');
            num -= 50;
        }

        int remainder = num / 10;
        while (remainder > 0) {
            subSection.append('X');
            num -= 10;
            remainder--;
        }

        if (num / 5 == 1) {
            subSection.append('V');
            num -= 5;
        }

        while (num > 0) {
            subSection.append('I');
            num--;

        }

        return subSection;

    }

    private class kibNum {
        char kib;
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
