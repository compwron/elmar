package mars;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsReader {

    private  Grid grid;
    private final ArrayList<Rover> rovers;

        public MarsReader(String fileLocation) throws FileNotFoundException {
        //        if there is a file at that location, use it. Else, use data.txt
        ArrayList<String> fileLines = linesFrom(fileLocation);

        this.grid = new Grid(fileLines.get(0));
        this.rovers = roversFrom(fileLines);
    }

    private ArrayList<Rover> roversFrom(ArrayList<String> possibleRovers){
        ArrayList<Rover> rovers = new ArrayList<Rover>();
        Pattern isRover = Pattern.compile("\\d \\d [NSEW]");
        for(String possibleRover : possibleRovers) {
            Matcher m = isRover.matcher(possibleRover);
            boolean yesRover = m.matches();
            if (yesRover == true) {
                rovers.add(new Rover(possibleRover));
            }
        }
        return rovers;
    }

    private ArrayList<String> linesFrom(String fileLocation) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileLocation));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }

    public Grid getGrid() {
        return grid;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }
}
