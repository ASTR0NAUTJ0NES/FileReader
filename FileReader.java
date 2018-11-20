/**
 * FileReader -- reads records (rows) from a file. 
 *
 * @author  Andrew Albanese
 * @version 11/10/2016
 */
import java.io.*; 
import java.util.Scanner;

public class FileReader  
{
    private int lineCount;      // number of lines processed thus far 
    private Scanner fileScan;   // scans the given file 
    private String fileName; 
    
    public FileReader(String filename) throws IOException 
    {
        this.lineCount = 0;
        this.fileScan = new Scanner(new File(filename));
    }
    public boolean hasNext()
    {
        return fileScan.hasNext();
    }
    public String nextLine() throws IOException
    {
        String line = ""; 
        if (fileScan.hasNext())
            {
                line = fileScan.nextLine();
                ++lineCount;
            }
        else
        {
            line = null;
        }
        return line; 
    }
    public int processFileSum()
    {    	
    	String line = "";
    	int numberOfLines = 0;
    	int totalOfScores = 0;    	
    	float averageOfScores = 0;
    	int max = 0;
    	int min = 110;
    	Scanner fileScan = new Scanner(fileName);
    	while(fileScan.hasNextLine())
    	{
    		line = fileScan.nextLine();
    		numberOfLines++;	
    		System.out.println("line: " + line);
    		
                Scanner delimiter = new Scanner(line);
                delimiter.useDelimiter(",");
                
                String outStr = "scores: ";
                totalOfScores = 0;
                while(delimiter.hasNext())
                {                
                    int score = Integer.parseInt(delimiter.next());
                    max = score > max ? score : max;
                    min = score < min ? score : min;
                    totalOfScores += score;
                    outStr += " " + delimiter.next();                      
                }
                System.out.println(outStr);  
                System.out.println("high: " + max + "low: " + min + " sum: " + totalOfScores);
    	}
    	return numberOfLines;
    }
    public int processFileAverage()
    {    	
    	String line = "";
    	int numberOfLines = 0;
    	int totalOfScores = 0;    	
    	float averageOfScores = 0;
    	int numOfScores = 0;
    	int max = 0;
    	int min = 110;
    	Scanner fileScan = new Scanner(fileName);
    	while(fileScan.hasNextLine())
    	{
    	   line = fileScan.nextLine();
    	   
    		numberOfLines++;	
    		System.out.println("line: " + line);
    		
                Scanner delimiter = new Scanner(line);
                delimiter.useDelimiter(",");
                
                String outStr = "scores: ";
                numOfScores = 0;
                totalOfScores = 0;
                while(delimiter.hasNext())
                {                
                    int score = Integer.parseInt(delimiter.next());
                    max = score > max ? score : max;
                    min = score < min ? score : min;
                    totalOfScores += score;
                    outStr += " " + delimiter.next();
                    numOfScores++;
                }
                System.out.println(outStr);  
                System.out.println("high: " + max + "low: " + min + " sum: " + totalOfScores);
    	}
    	return numOfScores;
    }
}