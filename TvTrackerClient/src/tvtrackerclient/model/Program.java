/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvtrackerclient.model;

/**
 *
 * @author Oskar Kowalewski
 */
public class Program {
    private String name;
    private String[] channelNames;
    private int[] hour;
    private int[] minutes;
    
    public Program(String programName)
    {
        name = programName;
    }
    
}
