Feature: Llenado de formulario

  Scenario: Llenar y enviar exitosamente el formulario
    Given Abrir la pagina del formulario
    When Llenar el formulario con data valida
    Then Ver que se completa exitosamente
