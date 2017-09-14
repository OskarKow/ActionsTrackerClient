/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvtrackerclient.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Oskar Kowalewski
 * 
 * Class represents channel with it's broadcast for current day.
 */
public class Channel {
    private String name;
    private LinkedList<ProgramBroadcast> broadcasts;
    private int numberOfBroadcasts;
    
    public Channel(String chName)
    {
        name = chName;
        numberOfBroadcasts = 0;
        broadcasts = new LinkedList<>();
    }
    
    public void addProgram(String name, int hour, int minutes)
    {
        numberOfBroadcasts++;
        broadcasts.add(new ProgramBroadcast(name, hour, minutes));
    }
    
    public LinkedList getBroadcasts()
    {
        return broadcasts;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void clearBroadcasts()
    {
        broadcasts.clear();
    }
}
