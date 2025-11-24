package br.com.gabrielrodrigues07.controllers;

import br.com.gabrielrodrigues07.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("One or two of the numbers provided are not in the correct format!!");
        }

        return convertToDuble(numberOne) + convertToDuble(numberTwo);
    }

    private Double convertToDuble(String strNumber) {
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (Objects.isNull(strNumber) || strNumber.isBlank()) return false;

        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
