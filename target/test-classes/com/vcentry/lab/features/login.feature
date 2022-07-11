 Feature: Validate Login
 
 #background is for precondition
  Background: Open browser and Launch Url
    Given User should open browser as "chrome"
    And User should Launch Url
    
  @validlogin
  Scenario: User Should able to login with valid credentials
    Given User should open browser as "chrome"
    And User should Launch Url 
    When User enter Username "standard_user"
    And User enter Password "secret_sauce"
    When Click on Login button 
    Then User should navigate to HomePage
    
    
  @invalidlogin
   Scenario Outline: user should not able to login with invalid credentials
   Given User should open browser as "<browser>"
    And User should Launch Url
    When User enter Username "<username>"
    And User enter Password "<pwd>"
    When Click on Login button 
    Then User should get error message
    Examples:
    |browser|username|pwd|
    |chrome|test|test123|
    |chrome|abctest|abc123|
    