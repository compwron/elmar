package mars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MarsWriter {
    private String outputFile;

    public MarsWriter(ArrayList<Rover> rovers) {

    }

    public void write() throws IOException {
        List<String> lines = new ArrayList<String>();
        Files.write(Paths.get(this.outputFile, lines);
    }
}
