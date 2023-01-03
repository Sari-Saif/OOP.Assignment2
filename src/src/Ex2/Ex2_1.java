package Ex2;

import java.io.FileWriter;
import java.io.BufferedReader;
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
                FileWriter fileWriter_i = new FileWriter("file_" + (i+1) + ".txt");

                // append random nunber of lines to the file.
                for(int j = 0; j < numOfLines; j++)
                {
                    fileWriter_i.write("Line number " + (j+1) + "\n");
                }

                fileWriter_i.close();

                // save the file name.
                textFileNames[i] = "file_" + (i+1) + ".txt";

            }catch (Exception e){}
        }

        return textFileNames;
    }

    public static int getNumOfLines(String[] fileNames)
    {
        int numOfLines = 0 ;
        for ( String name : fileNames)
        {
           try
           {
               // read the specific file
               BufferedReader fileReader = new BufferedReader(new FileReader(name));
               // get number of files by streaming
               numOfLines += fileReader.lines().count();
               fileReader.close();
           }

           catch (Exception e)
           {
               System.out.println(e.getMessage());
           }

        }
        return numOfLines;
    }

    public int getNumOfLinesThreads(String[] fileNames)
    {
        int counterNumOfLines = 0;

        GetNumOfLinesThread[]  arrGetNumOfLinesThread = new GetNumOfLinesThread[fileNames.length];

       for(int i = 0; i < fileNames.length; i++)
       {
           arrGetNumOfLinesThread[i] = new GetNumOfLinesThread();
           arrGetNumOfLinesThread[i].start();
       }

        for(int i = 0; i < fileNames.length; i++)
        {
            try
            {
                arrGetNumOfLinesThread[i].join();
                counterNumOfLines += arrGetNumOfLinesThread[i].get_numOfLines();
            }catch(Exception e){}
        }

        return counterNumOfLines;
    }

//    public int getNumOfLinesThreadPool(String[] fileNames)
//    {
//        //TODO
//    }
}
