package Ex2;

import java.util.Random;

public class Ex2_1
{
    public static String[] createTextFiles(int n, int seed, int bound)
    {
        // create random generator for number of lines in each file
        Random rand = new Random(seed);

        // create n file
        for(int i = 0; i < n; i++)
        {
            int numOfLines = rand.nextInt(bound);

            // TODO: create new file

            for(int j = 0; j < numOfLines; j++)
            {
                // TODO: append new line to the last file
            }

            // todo: delete this line

        }
    }

    public static int getNumOfLines(String[] fileNames)
    {
        //TODO
    }

    public int getNumOfLinesThreads(String[] fileNames)
    {
        //TODO
    }

    public int getNumOfLinesThreadPool(String[] fileNames)
    {
        //TODO
    }
}
