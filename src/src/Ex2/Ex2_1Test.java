package Ex2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.*;

class Ex2_1Test
{
    public static final int NUM_OF_FILES = 100;

    @Test
    void createTextFiles()
    {
        Ex2_1.createTextFiles(NUM_OF_FILES, 1, 1000);
    }

    @Test
    void getNumOfLines()
    {
        String[] filenames = new String[NUM_OF_FILES];

        for(int i = 0; i < NUM_OF_FILES; i++)
        {
            filenames[i] = "text_files\\file_" + (i+1) + ".txt";
        }

        System.out.println(Ex2_1.getNumOfLines(filenames));

    }

    @Test
    void getNumOfLinesThreads()
    {
        String[] filenames = new String[NUM_OF_FILES];

        for(int i = 0; i < NUM_OF_FILES; i++)
        {
            filenames[i] = "text_files\\file_" + (i+1) + ".txt";
        }

        System.out.println(Ex2_1.getNumOfLinesThreads(filenames));
    }
}