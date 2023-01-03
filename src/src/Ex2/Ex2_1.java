package Ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Random;

public class Ex2_1
{
    public static String[] createTextFiles(int n, int seed, int bound)
    {
        String[] textFileNames = new String[n];

        // create random generator for number of lines in each file
        Random rand = new Random(seed);

        // create n files
        for(int i = 0; i < n; i++)
        {
            int numOfLines = rand.nextInt(bound);

            try
            {
                // create new file
                FileWriter fileWriter_i = new FileWriter("file_" + i + ".txt");

                // append random nunber of lines to the file.
                for(int j = 0; j < numOfLines; j++)
                {
                    fileWriter_i.write("Line number " + j+1 + "\n");
                }

                // save the file name.
                textFileNames[i] = "file_" + i + ".txt";

            }catch (Exception e){}
        }

        return textFileNames;
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
