package mars;

import java.util.ArrayList;

public class Rover {
    private int x;
    private int y;
    private String direction;

    ArrayList<String> directions() {
        ArrayList<String> d = new ArrayList<String>();
        d.add("N");
        d.add("E");
        d.add("S");
        d.add("W");
        return d;
    }

    public Rover(String roverPosition) {
        String[] parts = roverPosition.split(" ");
        this.x = Integer.parseInt(parts[0]);
        this.y = Integer.parseInt(parts[1]);
        this.direction = directionFrom(parts[2]);
    }

    private String directionFrom(String part) {
        if (isDirection(part)) {
            return part;
        } else {
            System.out.println("Bad direction! Using N instead of " + part);
            return directions().get(0);
        }
    }

    private boolean isDirection(String part) {
        for (String direction : directions()) {
            if (direction.equals(part)) {
                return true;
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void move(String direction) {
        if (direction == "L") {
            Integer index = directions().indexOf(this.direction) - 1;
            if (index == -1) {
                index = directions().size() - 1;
            }
            this.direction = directions().get(index);
        } else if (direction == "R") {
            Integer index = directions().indexOf(this.direction) + 1;
            this.direction = directions().get(index);
        } else if (direction == "M") {

            move();
        }
    }

    private void move() {
        if (this.direction.equals("N")) {
            this.y++;
        } else if (this.direction.equals("E")) {
            this.x++;
        } else if (this.direction.equals("S")) {
            this.y--;
        } else if (this.direction.equals("W")) {
            this.x--;
        }

        if (this.x < 0) {
            this.x = 0;
        }

        if (this.y < 0) {
            this.y = 0;
        }
    }
}
