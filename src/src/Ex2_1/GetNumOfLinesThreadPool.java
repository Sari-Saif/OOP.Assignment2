package Ex2_1;

import java.util.concurrent.Callable;

public class GetNumOfLinesThreadPool implements Callable<Integer>
{
     private String filename;


    /**
     * The constructor.
     * @param filename is name of existing file for counting the
     *                 number of lines inside it.
     */
    public GetNumOfLinesThreadPool(String filename)
    {
        this.filename = filename;

    }


    /**
     * function call override call of Callable
     * @return the number of lines of file.
     * @throws Exception if something go wrong in calculate.
     */
    @Override
    public Integer call() throws Exception
    {
        String[] arrWithOneFilename = new String[1];
        arrWithOneFilename[0] = this.filename;
        return Ex2_1.getNumOfLines(arrWithOneFilename);
    }
}
