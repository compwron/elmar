 package mars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void hasPosition() {
        String roverPosition = "1 2 E";
        Rover rover = new Rover(roverPosition);
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getDirection(), "E");
    }

    @Test
    public void turnsRight() {
        String roverPosition = "1 2 E";
        Rover rover = new Rover(roverPosition);
        rover.move("R");
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getDirection(), "S");
    }

    @Test
    public void turnsLeft() {
        String roverPosition = "1 2 E";
        Rover rover = new Rover(roverPosition);
        rover.move("L");
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getDirection(), "N");
    }

    @Test
    public void movesForwardWhenFacingNorth() {
        String roverPosition = "1 2 N";
        Rover rover = new Rover(roverPosition);
        rover.move("M");
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 3);
        assertEquals(rover.getDirection(), "N");
    }

    @Test
    public void movesForwardWhenFacingEast() {
        String roverPosition = "1 2 E";
        Rover rover = new Rover(roverPosition);
        rover.move("M");
        assertEquals(rover.getX(), 2);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getDirection(), "E");
    }

    @Test
    public void movesForwardWhenFacingSouth() {
        String roverPosition = "1 2 S";
        Rover rover = new Rover(roverPosition);
        rover.move("M");
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 1);
        assertEquals(rover.getDirection(), "S");
    }

    @Test
    public void movesForwardWhenFacingWest() {
        String roverPosition = "1 2 W";
        Rover rover = new Rover(roverPosition);
        rover.move("M");
        assertEquals(rover.getX(), 0);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getDirection(), "W");
    }

    @Test
    public void doesNotMoveWhenMovingOffGrid() {
        String roverPosition = "0 0 S";
        Rover rover = new Rover(roverPosition);
        rover.move("M");
        assertEquals(rover.getX(), 0);
        assertEquals(rover.getY(), 0);
        assertEquals(rover.getDirection(), "S");
    }
}
