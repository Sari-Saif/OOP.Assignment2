package Ex2_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ex2_1Test
{
    public static final int NUM_OF_FILES_1 = 10;
    public static final int NUM_OF_FILES_2 = 100;
    public static final int NUM_OF_FILES_3 = 1000;
    public static final int NUM_OF_FILES_4 = 10000;

    public static final int BOUND_1 = 10;
    public static final int BOUND_2 = 100;
    public static final int BOUND_3 = 1000;

    @Test
    void createTextFiles()
    {
        Ex2_1.createTextFiles(NUM_OF_FILES_1, 1, BOUND_1);
    }

    @Test
    void getNumOfLines()
    {
        String[] filenames = new String[NUM_OF_FILES_1];
        Ex2_1 threadsUsing = new Ex2_1();
        for(int i = 0; i < NUM_OF_FILES_1; i++)
        {
            filenames[i] = "files_for_test\\file_" + (i+1) + ".txt";
        }
        assertEquals (57,threadsUsing.getNumOfLinesThreads(filenames));

    }

    @Test
    void getNumOfLinesThreads()
    {
        Ex2_1 threadsUsing = new Ex2_1();
        String[] filenames = new String[NUM_OF_FILES_1];

        for(int i = 0; i < NUM_OF_FILES_1; i++)
        {
            filenames[i] = "files_for_test\\file_" + (i+1) + ".txt";
        }
        assertEquals(57,threadsUsing.getNumOfLinesThreads(filenames));
    }

    @Test
    void getNumOfLinesThreadPool()
    {
        Ex2_1 threadPoolUsing = new Ex2_1();
        String[] filenames = new String[NUM_OF_FILES_1];

        for(int i = 0; i < NUM_OF_FILES_1; i++)
        {
            filenames[i] = "files_for_test\\file_" + (i+1) + ".txt";
        }

        assertEquals(57,threadPoolUsing.getNumOfLinesThreadPool(filenames));

    }
}