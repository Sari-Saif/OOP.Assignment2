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
        String[] filenames = {"wishes_text\\test_me1.txt",
                "wishes_text\\test_me2.txt",
                "wishes_text\\test_me3.txt",
                "wishes_text\\test_me4.txt",
                "wishes_text\\test_me5.txt",
                "wishes_text\\test_me6.txt",
                "wishes_text\\test_me7.txt",
                "wishes_text\\test_me8.txt",
                "wishes_text\\test_me9.txt",
                "wishes_text\\test_me10.txt",
                "wishes_text\\test_me11.txt",
                "wishes_text\\test_me12.txt",
                "wishes_text\\test_me13.txt",
                "wishes_text\\test_me14.txt",
                "wishes_text\\test_me15.txt",
                "wishes_text\\test_me16.txt"};
        assertEquals(70*2*2 , Ex2_1.getNumOfLines(filenames) );
    }

    @Test
    void getNumOfLinesThreads()
    {
        String[] filenames = {"wishes_text\\test_me1.txt",
                "wishes_text\\test_me2.txt",
                "wishes_text\\test_me3.txt",
                "wishes_text\\test_me4.txt",
                "wishes_text\\test_me5.txt",
                "wishes_text\\test_me6.txt",
                "wishes_text\\test_me7.txt",
                "wishes_text\\test_me8.txt",
                "wishes_text\\test_me9.txt",
                "wishes_text\\test_me10.txt",
                "wishes_text\\test_me11.txt",
                "wishes_text\\test_me12.txt",
                "wishes_text\\test_me13.txt",
                "wishes_text\\test_me14.txt",
                "wishes_text\\test_me15.txt",
                "wishes_text\\test_me16.txt"};
        assertEquals(70*2*2 , Ex2_1.getNumOfLinesThreads(filenames));
    }
}