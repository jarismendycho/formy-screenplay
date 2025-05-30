Feature: API de JSONPlaceholder

  Scenario: Obtener un post por su ID
    Given la API está disponible con la URL base "https://jsonplaceholder.typicode.com"
    When obtengo el post con ID 1
    Then el código de estado de la respuesta debe ser 200
    And el campo title debe ser "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"