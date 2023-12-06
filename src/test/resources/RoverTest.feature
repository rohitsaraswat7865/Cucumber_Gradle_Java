@regression
Feature: Mars rover test

  Scenario Outline: (a) Write a test for Rover direction facing and positioning initialisation
    Given Mars rover is deployed on a grid starting from origin
    When Rover has <X> as x co ordinate and <Y> as y co ordinate and facing <DIRECTION> direction
    Then Verify rover got <POSITION> as its initialized position
    Examples:
      | X | Y | DIRECTION | POSITION |
      | 1 | 2 | north     | 1 2 N    |
      | 3 | 3 | east      | 3 3 E    |

  Scenario Outline: (b,c) Write A test for moving the rover x and y position and location
    Given Mars rover is deployed on a grid starting from origin
    When Rover has <X> as x co ordinate and <Y> as y co ordinate and facing <DIRECTION> direction
    And User passes command <INPUT> to move the rover
    Then Verify rover got <POSITION> as its final position
    Examples:
      | X | Y | DIRECTION | INPUT       | POSITION |
      | 1 | 2 | north     | LMLMLMLMM   | 1 3 N    |
      | 3 | 3 | east      | MMRMMRMRRM  | 5 1 E    |

