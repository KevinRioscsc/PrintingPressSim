/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public class Job {
    private static int ID = 0;
    private int startTime;
    private int endTime;
    private int waitTime;
    private int arrivalTime;
    private int timeForjob;
    
    public Job(int arrivalTime1, int timeForjob1)
    {
        arrivalTime = arrivalTime1;
        timeForjob = timeForjob1;
        ID++;
    }
    
    
    public int ID()
    {
        return ID;
    }
    public void setStartTime(int x)
    {
        waitTime = x - arrivalTime;
        startTime = x;
    }
    public void setEndTime(int x)
    {
        endTime =x;
    }
    public void setTimeForJob(int x)
    {
       timeForjob = x;
    }
    public void setArrivalTime(int x)
    {
        arrivalTime = x;
    }
    public int getWaitTime()
    {
        return waitTime;
    }
    public int getStartTime()
    {
        return startTime;
    }
    public int getEndTime()
    {
        return endTime;
    }
    public int getTimeForJob()
    {
        return timeForjob;
    }
    public int getArrivalTime()
    {
        return arrivalTime;
    }
}
