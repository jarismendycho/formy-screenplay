Feature: Form submission on Formy

  Scenario: Successfully fill and submit the form
    Given Jorge opens the form page
    When he fills in the form with valid data
    Then he should see a successful submission
