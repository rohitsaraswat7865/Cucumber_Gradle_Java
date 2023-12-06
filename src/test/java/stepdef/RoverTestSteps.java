package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marsrover.*;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class RoverTestSteps {

    private Rover roverObj;

    public RoverTestSteps(Rover roverObj){
        this.roverObj = roverObj;
    }

    @Given("Mars rover is deployed on a grid starting from origin")
    public void marsRoverIsDepoyedOnAGrid() {
        //Given x = 0; y = 0; in Rover.java
    }

    @When("^Rover has ([0-9]+) as x co ordinate and ([0-9]+) as y co ordinate and facing (east|west|north|south) direction$")
    public void roverHasXAsXCoOrdinateAndYAsYCoOrdinate(Integer x, Integer y, String direction) {
        try{
            int xCoordinate = x;
            int yCoordinate = y;
            int directionValue = 0;
            if(direction.equals("north")){
                directionValue = Rover.N;
            }else if(direction.equals("south")){
                directionValue = Rover.S;
            }else if(direction.equals("east")){
                directionValue = Rover.E;
            }else if(direction.equals("west")){
                directionValue = Rover.W;
            }
            roverObj.setPosition(xCoordinate, yCoordinate, directionValue);
        }catch(Exception ex){
            Assertions.fail(ex.getCause());
        }
    }

    @Then("^Verify rover got ([0-9_E_W_N_S_' ']+) as its (initialized|final) position$")
    public void verifyRoverGotPOSITIONAsItsInitializedPosition(String position, String destination) {
        try{
            //log destination
            String positionToMatch = position.trim();
            String currentPosition = roverObj.printPosition();
            Assertions.assertEquals(positionToMatch,currentPosition);
        }catch(Exception ex){
            Assertions.fail(ex.getCause());
        }
    }

    @And("^User passes command ([A-Z]+) to move the rover$")
    public void userPassesCommandINPUTToMoveTheRover(String input) {
        try{
           roverObj.process(input.trim());
        }catch(Exception ex){
            Assertions.fail(ex.getCause());
        }
    }
}
