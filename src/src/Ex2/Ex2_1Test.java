package Ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_1Test
{
    @Test
    void createTextFiles()
    {
        Ex2_1.createTextFiles(5, 1, 10);
    }

    @Test
    void getNumOfLines()
    {
        String[] filenames = {"test_me1.txt", "test_me2.txt", "test_me3.txt"};
        System.out.println("number of lines of all files: " + Ex2_1.getNumOfLines(filenames));
    }
}