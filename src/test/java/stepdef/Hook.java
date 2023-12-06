package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import marsrover.*;

public class Hook {

    private Rover roverObj;

    public Hook(Rover roverObj){
        this.roverObj = roverObj;
    }

    @Before
    public void Before(){}

    @After
    public void After(){}


}
