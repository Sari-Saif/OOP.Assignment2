package Ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_1Test
{

    String[] filenames;

    @Test
    void createTextFiles()
    {
        filenames = Ex2_1.createTextFiles(5, 2, 5);
    }

    @Test
    void getNumOfLines()
    {
        System.out.println("number of lines of all files: " + Ex2_1.getNumOfLines(filenames));
    }
}