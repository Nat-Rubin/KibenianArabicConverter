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


    // Exceptions!
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void emptyStringTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("");
    }
    @Test(expected = MalformedNumberException.class)
    public void malformedNumberDoubleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("1.1");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberDoubleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("0.111");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSignedDoubleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("0.111");
    }
    @Test(expected = MalformedNumberException.class)
    public void malformedNumberBadVaues() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("abdc");
    }
    //too many Xs
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber1() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("XXXXX");
    }
    //too many Ls
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber2() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("LLL");
    }

    //too many Vs
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber3() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("VV");
    }

    //too many Is
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber4() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("IIIII");
    }
    //X before L
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber5() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("XL");
    }
    //V before X
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber6() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("VX");
    }
    //I before V
    @Test(expected = MalformedNumberException.class)
    public void malformedNumber7() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("IV");
    }


    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTooLargeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("999999");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTooSmallTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("-1");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTooSmallTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("-9999");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBounds0Test() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("0");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLeading0sTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("0000001");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLargeLeading0sTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("0098401");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberStartsWith_Test() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("_VI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberIllegalCharactersWithNumbersTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("VIII5345");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberIllegalCharactersTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("@#$%$#@%$%");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSpacesTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("V _V");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSubgroupTooLargeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("LXXXXVIIII");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumber2ndSubgroupTooLargeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("L_LXXXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSubgroupTooLargeTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("LL");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSubgroupTooLargeTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        new KibenianArabicConverter("LX");
    }

    // Arabic to Kibenian tests

    @Test
     public void malformedNumberNotArabicNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter test = new KibenianArabicConverter("LVI");
        assertEquals("LVI", test.toKibenian());
    }
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
        assertEquals(converter.toKibenian(), "I_");
    }
    @Test
    public void ArabicToKibenianSampleTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3605");
        assertEquals(converter.toKibenian(), "I__V");
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
        assertEquals(converter.toKibenian(), "VIIII");
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
    //test double underscore with single values on left and right
    @Test
    public void KibenianToArabicSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L__L");
        assertEquals(converter.toArabic(), 180050);
    }

    //test single underscore test with no value on right
    @Test
    public void KibenianToArabicSampleTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L_");
        assertEquals(converter.toArabic(), 3000);
        assertEquals(converter.toArabic(), 3000);
    }

    //test single underscore test
    @Test
    public void KibenianToArabicSampleTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L_L");
        assertEquals(converter.toArabic(), 3050);
    }



    //test single underscore test
    @Test
    public void KibenianToArabicSampleTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L_L");
        assertEquals(converter.toArabic(), 3050);
    }

    @Test
    public void KibenianToArabicSampleTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        assertEquals(converter.toArabic(), 10);
    }

    @Test
    public void KibenianToArabicSampleTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I_I_I");
        assertEquals(converter.toArabic(), 3661);
    }
    @Test
    public void KibenianToArabicSampleTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVI_XXXI_V");
        assertEquals(converter.toArabic(), 203465);
    }

    @Test
    public void KibenianToArabicSampleTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LV_XVIII_LII");
        assertEquals(converter.toArabic(), 199132);
    }

    @Test
    public void KibenianToArabicSampleTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXXIIII_LVIIII_LII");
        assertEquals(converter.toArabic(), 161992);
    }


    @Test
    public void KibenianToArabicSampleTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXI_VI_XXXIII");
        assertEquals(converter.toArabic(), 111993);
    }

    @Test
    public void KibenianToArabicSampleTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I_XX_XVIIII");
        assertEquals(converter.toArabic(), 4819);
    }








}
