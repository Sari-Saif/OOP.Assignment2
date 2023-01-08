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


    /**
     * function getter
     * @return the number of lines class member.
     */
    public int get_numOfLines()
    {
        return this.numberOfLines;
    }


    /**
     * function run override run of Thread.
     * The goal is to save the result inside
     * class member, because run() can't returns value.
     */
    @Override
    public void run()
    {
        String[] arrWithOneFilename = new String[1];
        arrWithOneFilename[0] = this.filename;

        // using function for counting number of lines was written before.
        numberOfLines = Ex2_1.getNumOfLines(arrWithOneFilename);
    }
}
