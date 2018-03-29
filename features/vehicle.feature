Feature: Register new vehicle
  Scenario: Register new vehicle
    Given I am connected to the WOF database
    And The Owner with the email "gavgog1@gmail.com" exists
    When I Create a new vehicle with vinNum "375696"
    Then Next time I retrive information from the table vehicle, it will contain a vehicle with vinNum "375696"