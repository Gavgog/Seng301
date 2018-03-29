Feature: Register new owner
  Scenario: Register new owner
    Given I am connected to the WOF database
    When I Register a new owner with values "bob@gmail.com,bobby,bobson,bobsmyname"
    Then Next time I retrive information from the table , it will contain an owner with the email "bob@gmail.com"