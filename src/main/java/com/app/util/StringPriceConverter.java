package com.app.util;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * Class converts price value in string to double
 *
 * @author Eugene Kurbatov
 */
public class StringPriceConverter extends StrutsTypeConverter {
    /**
     * Converts one or more String values to the specified class
     *
     * @param map the action context
     * @param strings the String values to be converted, such as those submitted from an HTML form
     * @param aClass the class to convert to
     *
     * @return the converted object
     */
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        try {
            if (NumberUtils.isNumber(strings[0])) {
                return Double.parseDouble(strings[0]);
            }
            return 0.0;
        } catch (Exception e) {
            throw new TypeConversionException(e);
        }
    }

    /**
     * Converts the specified object to a String
     *
     * @param map the action context
     * @param o the object to be converted
     *
     * @return the converted String
     */
    @Override
    public String convertToString(Map map, Object o) {
        try {
            return o.toString();
        } catch (Exception e) {
            throw new TypeConversionException(e);
        }
    }
}
