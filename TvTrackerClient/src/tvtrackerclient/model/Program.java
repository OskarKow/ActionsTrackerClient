
package tvtrackerclient.model;

import java.util.LinkedList;

/**
 *
 * @author Oskar Kowalewski
 */
public class Program {
    private String name;
    private LinkedList<ChannelBroadcast> broadcasts;
    
    public Program(String programName)
    {
        name = programName;
        broadcasts = new LinkedList<>();
    }
    
    public void addChannel(String channelName, String time, String date)
    {
        System.out.println(channelName + " " + time + " " + date);
        broadcasts.add(new ChannelBroadcast(channelName, time, date));
    }
    
    public void setName(String programName)
    {
        name = programName;
    }
    public String getName()
    {
        return name;
    }
    
    public LinkedList getBroadcasts()
    {
        return broadcasts;
    }
    
    public void clearBroadcasts()
    {
        broadcasts.clear();
    }
    
}
