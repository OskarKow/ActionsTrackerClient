
package tvtrackerclient.model;

/**
 *
 * @author Oskar Kowalewski
 */
public class ChannelBroadcast {
    private String channelName;
    private String emissionTime;
    private String emissionDate;
    
    public ChannelBroadcast(){
        
    }
    
    public ChannelBroadcast(String name, String time, String date)
    {
        channelName = name;
        emissionTime = time;
        emissionDate = date;
    }
    
    public void setChannelName(String name)
    {
        channelName = name;
    }
    public void setEmissonTime(String time)
    {
        emissionTime = time;
    }
    public void setEmissonDate(String date)
    {
        emissionDate = date;
    }
    
    public String getChannelName()
    {
        return channelName;
    }
    public String getEmissionTime()
    {
        return emissionTime;
    }
    public String getEmissionDate()
    {
        return emissionDate;
    }
}
