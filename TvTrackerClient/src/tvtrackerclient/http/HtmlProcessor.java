
package tvtrackerclient.http;

import java.util.Scanner;
import tvtrackerclient.model.Channel;
import tvtrackerclient.model.Program;

/**
 *
 * @author Oskar Kowalewski
 * 
 * Class will contain methods for searching some desired data in HTML document
 */
public final class HtmlProcessor {
    
    //Method will set Channel's information about broadcasts
    public static void fillChannelBroadcasts(String htmlDocument, Channel channel)
    {
        Scanner scan = new Scanner(htmlDocument);
        channel.clearBroadcasts();
        if(moveScannerChannelSearch(scan) == true)
        {
            //now the scanner is at the begginig of tv program section in html code
            while(addNextBroadcastToChannel(scan, channel) == true)
            {

            }
        }else{
            System.out.println("ERROR. PROGRAMS NOT FOUND");
        }
    }
    
    //method moves Scanner to the point in html code where channel's program begins and returns true or returns false when it doesnt find one
    private static boolean moveScannerChannelSearch(Scanner scan)
    {
        String line;
        //Look for start of broadcasts in html code
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            if(line.contains("id=\"rano\"")) //broadcast starts with html element with id="rano"
                return true;
        }
        return false;
    }
    
    //if method finds next program it adds it to the channel's object ( or no if it's 'commercial' <li>),
    //moves scanner to the end of <li> html element and returns true, returns false otherwise.
    private static boolean addNextBroadcastToChannel(Scanner scan, Channel channel)
    {
        String line;
        String name = "";
        int hour;
        int minutes;
        
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            if(line.contains("class=\"reklama\""))
            {
                //skip whole <li> element
                while(scan.hasNextLine())
                {
                    line = scan.nextLine();
                    if(line.contains("</li>"))
                        return true;
                }
            }
            //getting data from <span> and <em>
            if(line.contains("<span>"))
                name = getNameFromSpan(line);
            if(line.contains("<em>"))
            {
                hour = getHourFromEm(line);
                minutes = getMinutesFromEm(line);
                //all data have been gathered
                channel.addProgram(name, hour, minutes);
                return true;
            }
            if(line.contains("</li>"))
                return true;
        }
        return false;
    }
    //html format: <span> Program Name </span>
    private static String getNameFromSpan(String codeLine)
    {
        return codeLine.substring(6, codeLine.length() - 7); // we remove <span> and </span>
    }
    
    //html format: <em> Hour:Minutes </em>
    // -1 is error flag
    private static int getHourFromEm(String codeLine)
    {
        Scanner scan = new Scanner(codeLine);
        scan.useDelimiter("\\D+");

        if(scan.hasNextInt())
        {
            return scan.nextInt();
        }
        return -1;
    }
    
    private static int getMinutesFromEm(String codeLine)
    {
        Scanner scan = new Scanner(codeLine);
        scan.useDelimiter("\\D+");
        if(scan.hasNextInt())
        {
            scan.nextInt();
            if(scan.hasNextInt()) //to avoid Hour
            {
                return scan.nextInt();
            }
        }
        return -1;
    }
    
    public static void fillProgramBroadcasts(String htmlDocument, Program program)
    {
        Scanner scan = new Scanner(htmlDocument);
        //first we have to find url to program's site, then find needed info in there
        System.out.println(findProgramURL(scan));
    }
    
    //we look for program url inside of html code
    private static String findProgramURL(Scanner scan)
    {
        String result = "";
        String line;
        //Look for start of broadcasts in html code
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            line = line.replace(" ","");
            if(line.contains("<h2>Programy</h2>")) //broadcast starts with html element <h2>Programy</h2>
            {
                //now we look for first link after Program section in html code
                while(scan.hasNextLine())
                {
                    line = scan.nextLine();
                    if(line.contains("<a href="))
                    {
                        line = line.replace(" ", "");
                        result = line.substring(8,line.length() - 2);
                        return result;
                    }
                }
            }
        }
        return result;
    }

}





