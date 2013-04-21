package com.app.util;

import junit.framework.TestCase;
import com.app.util.StringPriceConverter;


public class StringPriceConverterTest extends TestCase {
    private StringPriceConverter stringPriceConverter;

    @Override
    protected void setUp() throws Exception {
        stringPriceConverter = new StringPriceConverter();
    }

    public void testConvertFromString() throws Exception {
        String[] inputs1 = {"200"};
        Object result = stringPriceConverter.convertFromString(null, inputs1, Double.TYPE);
        assertEquals(200.0, result);

        String[] inputs2 = {"199.55"};
        result = stringPriceConverter.convertFromString(null, inputs2, Double.TYPE);
        assertEquals(199.55, result);

        String[] inputs3 = {""};
        result = stringPriceConverter.convertFromString(null, inputs3, Double.TYPE);
        assertEquals(0.0, result);

        String[] inputs4 = {"text"};
        result = stringPriceConverter.convertFromString(null, inputs4, Double.TYPE);
        assertEquals(0.0, result);
    }

    public void testConvertToString() throws Exception {
        assertEquals("200.0", stringPriceConverter.convertToString(null, 200.0));
        assertEquals("199.55", stringPriceConverter.convertToString(null, 199.55));
    }
}
