Feature: Servicio SOAP Calculator

  Background:
  Dado que el servicio SOAP Calculator está disponible en "http://www.dneonline.com/calculator.asmx"

  Scenario: Sumar 5 y 3
    When llamo a la operación "Add" con operandos 5 y 3
    Then el código de estado debe ser 200
    And el resultado de la suma debe ser 8

  Scenario: Restar 10 y 4
    When llamo a la operación "Subtract" con operandos 10 y 4
    Then el código de estado debe ser 200
    And el resultado de la resta debe ser 6