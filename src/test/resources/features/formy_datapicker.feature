Feature: Datepicker en Formy

  Scenario: Seleccionar una fecha con el datepicker
    Given Abrir la página del datepicker
    When Elegir la fecha "05/28/2025"
    Then Se debería ver la fecha "05/28/2025" en el campo