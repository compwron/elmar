package mars;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileLocation = args[0];
        MarsReader marsReader = new MarsReader(fileLocation);
        Grid grid = marsReader.getGrid();
        ArrayList<Rover> rovers = marsReader.getRovers();
        MissionControl missionControl = new MissionControl(grid, rovers);
        for (Rover rover : rovers) {
            missionControl.moveRover(rover, grid);
        }

        MarsWriter marsWriter = new MarsWriter(rovers);
        marsWriter.write();
    }
}
