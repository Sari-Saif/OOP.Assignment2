package Ex2_1;

public class GetNumOfLinesThread extends Thread
{
    private int numberOfLines;
    private String filename;


    /**
     * The constructor.
     * @param fileName is name of existing file for counting the
     *                 number of lines inside it.
     */
    GetNumOfLinesThread(String fileName)
    {
        this.filename = fileName;
    }
    public int get_numOfLines()
    {
        return this.numberOfLines;
    }

    @Override
    public void run()
    {
        String[] arrWithOneFilename = new String[1];
        arrWithOneFilename[0] = this.filename;
        numberOfLines = Ex2_1.getNumOfLines(arrWithOneFilename);
    }
}
