package Ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        // initial number for lines
        int NumOfLines = 0 ;
        for( int i =0 ; i < fileNames.length ; i++)
        {
           try {
               // we get the name of file 'i'
               String name_Of_file = fileNames[i];
               // read the specific file
               BufferedReader fileReader = new BufferedReader(new FileReader(name_Of_file));
               // get number of files by streaming .
               NumOfLines += fileReader.lines().count();
           }
           catch (Exception e){}

        }
        return NumOfLines;
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
