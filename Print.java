/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public class Print {
    private String printName;
    private Job var = null;
    private int startIdletime;
    private int startInUseTime;
    private int totalIdleTime;
    private int totalInUseTime;
    private int totalJobsProcessed;
    
    public Print(String n)
    {
        printName = n;
    }

    
    public void setprintName(String n)
    {
        printName = n;
    }
    public String getprintName()
    {
        return printName;
    }
    public void setvar(Job n)
    {
        var = n;
    }
    public Job getvar()
    {
        return var;
    }
    public void setstartInUseTime(int n)
    {
        totalJobsProcessed++;
        startInUseTime = n;
    }
    
    public void setStartidletime(int n)
    {
        totalInUseTime=n - totalInUseTime;
        startIdletime = n;
    }
    public void settotalIdleTime(int n)
    {
       totalIdleTime= n -totalIdleTime;
    }
    public int gettotalIdleTime()
    {
        return totalIdleTime;
    }
    public int gettotalInUseTime()
    {
        return totalInUseTime;
    }
    public int gettotalJobsProcessed()
    {
        return totalJobsProcessed;
    }
    
}
