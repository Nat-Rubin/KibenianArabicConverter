package converter.tests;

import converter.KibenianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the KibenianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void KibenianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toKibenian(), "I");
    }

    @Test
    public void ArabicToKibenianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases


    @Test
    public void ArabicToKibenianSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("215999");
        assertEquals(converter.toKibenian(), "LVIIII__LVIIII_LVIIII");
    }
    @Test
    public void ArabicToKibenianSampleTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("215998");
        assertEquals(converter.toKibenian(), "LVIIII__LVIIII_LVIII");
    }
    @Test
    public void ArabicToKibenianSampleTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("60");
        assertEquals(converter.toKibenian(), "LVIIII_I");
    }
    @Test
    public void ArabicToKibenianSampleTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3605");
        assertEquals(converter.toKibenian(), "LVIIII__V");
    }


    @Test
    public void ArabicToKibenianSampleTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("5");
        assertEquals(converter.toKibenian(), "V");
    }
    @Test
    public void ArabicToKibenianSampleTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        assertEquals(converter.toKibenian(), "X");
    }
    @Test
    public void ArabicToKibenianSampleTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("9");
        assertEquals(converter.toKibenian(), "LVIIII");
    }

    @Test
    public void ArabicToKibenianSampleTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("215999");
        assertEquals(converter.toKibenian(), "LVIIII__LVIIII_LVIIII");
    }

    @Test
    public void ArabicToKibenianSampleTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("215999");
        assertEquals(converter.toKibenian(), "LVIIII__LVIIII_LVIIII");
    }
















    //Kibenian to Arabic tests
    @Test
    public void KibenianToArabicSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIII__LVIII");
        assertEquals(converter.toArabic(), "LVIIII__V");
    }



}
