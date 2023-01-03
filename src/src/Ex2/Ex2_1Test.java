package Ex2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.*;

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
        String[] filenames = {"wishes_text\\test_me1.txt", "wishes_text\\test_me2.txt", "wishes_text\\test_me3.txt","wishes_text\\test_me4.txt"};
        assertEquals(70 , Ex2_1.getNumOfLines(filenames) );
    }
}