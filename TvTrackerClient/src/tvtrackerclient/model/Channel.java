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
    private LinkedList<String> programNames;
    private LinkedList<Integer> programHours;
    private LinkedList<Integer> programMinutes;
    private int numberOfBroadcasts;
    
    public Channel(String chName)
    {
        name = chName;
        numberOfBroadcasts = 0;
        programNames = new LinkedList<>();
        programHours = new LinkedList<>();
        programMinutes = new LinkedList<>();
    }
    
    public void addProgram(String name, int hour, int minutes)
    {
        numberOfBroadcasts++;
        programNames.add(name);
        programHours.add(hour);
        programMinutes.add(minutes);
        System.out.println(name + " " + hour + " " + minutes);
    }
}
