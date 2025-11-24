package br.com.gabrielrodrigues07.util;

import br.com.gabrielrodrigues07.exceptions.UnsupportedMathOperationException;

import java.util.Objects;

public class ValidateAndConverterUtils {

    public static Double convertToDuble(String strNumber) {
        if (!ValidateAndConverterUtils.isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException(String.format("Value '%s' isn't a number", strNumber));
        }

        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private static boolean isNumeric(String strNumber) {
        if (Objects.isNull(strNumber) || strNumber.isBlank()) return false;

        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
