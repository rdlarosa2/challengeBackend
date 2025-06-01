package com.tenpo.challengeBackend.rest;

import com.tenpo.challengeBackend.service.CalculatorService;
import com.tenpo.challengeBackend.service.exceptions.NoPercentageStoredRecentlyException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/calculator")
@Tag(name="Puntos finales del API Rest Calculadora", description="Punto final para calcular la suma de dos numeros")
public class CalculatorRestController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorRestController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Operation(summary="Suma dos numeros decimales y le aplica un porcentaje", description="Suma dos numeros decimales y a esta suma le aplica un porcentaje")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/suma/num1={num1}&num2={num2}")
    public double suma( @PathVariable(name="num1") double num1,@PathVariable(name="num2")  double num2 ) {

        return this.calculatorService.suma(num1,num2) ;
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(NoPercentageStoredRecentlyException exc) {
        UserErrorResponse error = new UserErrorResponse(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
