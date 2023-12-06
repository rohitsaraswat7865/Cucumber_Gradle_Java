package marsrover;

import org.picocontainer.Disposable;

/*
1) TestObject i.e. Rover is a disposable object
2) Inject dependency of rover in cucumber step definitions
 */
public class Rover implements Disposable {
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    int x = 0;
    int y = 0;
    int facing = N;
    public Rover() {
    }
    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    public String printPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        String rslt = x +" " +y +" "+dir;
        System.out.println(rslt);
        return rslt;
    }
    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.charAt(idx));
        }
    }
    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
    }
    private void move() {
        if (facing == N) {
            this.y++;
        } else if (facing == E) {
            this.x++;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
    }



    @Override
    public void dispose() {

    }
}
