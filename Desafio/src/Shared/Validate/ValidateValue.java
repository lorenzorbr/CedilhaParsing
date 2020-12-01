package Shared.Validate;

import Shared.Constants.Constants;

import java.util.regex.Pattern;

public class ValidateValue {
    public static boolean validateValue(String value, String regex) {
        if(value.isBlank())
            return false;
        if(!value.contains(".") && regex.equals(Constants.REGEX.DOUBLE))
            value += ".00";
        boolean match = Pattern.matches(regex, value);
        return match;
    }

    public static boolean validateSaleID(String data) {
        return !data.isBlank() && Pattern.matches(Constants.REGEX.INTEGER, data);
    }
}
