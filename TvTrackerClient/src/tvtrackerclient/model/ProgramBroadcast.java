
package tvtrackerclient.model;

/**
 *
 * @author Oskar Kowalewski
 * 
 * class used to popuate TableView's cells. Channel will have list of ProgramBroadcast type
 */
public class ProgramBroadcast {
    private String programName;
    private int programHour;
    private int programMinutes;
    private String stringTimeRepresentation; //hh:mm
    
    public ProgramBroadcast(){
   
    }
    
    public ProgramBroadcast(String name, int hour, int minutes)
    {
        programName = name;
        programHour = hour;
        programMinutes = minutes;
        stringTimeRepresentation = timeFormat();
    }
    
    //method returns hh:mm format for programHour and programName
    private String timeFormat()
    {
        String result = "";
        
        if(programHour < 10)
        {
            result += "0";
        }
        result += programHour + ":";
        if(programMinutes < 10)
        {
            result += "0";
        }
        result += programMinutes;
        
        return result;
    }
    
    public void setProgramName(String newName)
    {
        programName = newName;
    }
    
    public void setProgramHour(int newHour)
    {
        programHour = newHour;
    }
    
    public void setProgramMinutes(int newMinutes)
    {
        programMinutes = newMinutes;
    }
    
    public String getProgramName()
    {
        return programName;
    }
    
    public int getProgramHour()
    {
        return programHour;
    }
    
    public int getProgramMinutes()
    {
        return programMinutes;
    }
    
    public String getStringTimeRepresentation()
    {
        return stringTimeRepresentation;
    }
}
