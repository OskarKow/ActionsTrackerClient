/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvtrackerclient.model;

/**
 *
 * @author Oskar Kowalewski
 * 
 * Class represents channel with it's broadcast for current day.
 */
public class Channel {
    private String name;
    private String[] programNames;
    private int[] programHours;
    private int[] programMinutes;
    private int numberOfBroadcasts;
    
    public Channel(String chName)
    {
        name = chName;
    }
}
