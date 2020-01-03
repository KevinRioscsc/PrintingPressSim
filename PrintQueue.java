/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */

import java.util.Random;

public class PrintQueue {
    Random randy;
    //until printer pulls from job
    Queue<Job> Waitqueue;
    private int totalWaittime;
    Queue<Job> finishedQueue;//when job is finished
    private static int currentTime = 0;
    private static int currentTime2=0;
    Print[] print;
    private int NumberofPrinter;
    private final int NumberofPrintJobs;
     int JobTime;
     int totalJobsProc;
     Job job;
     Job jobRemove;
  
    public PrintQueue(int x, int y)
    {
       NumberofPrinter = x;
        NumberofPrintJobs = y;
        randy = new Random();
        Waitqueue = new Queue<>(NumberofPrintJobs);
        finishedQueue = new Queue<>(NumberofPrintJobs);
        print = new Print[NumberofPrinter];
        for(int i = 0; i < NumberofPrinter; i ++)
        {
            print[i] = new Print("Printer" +i);
        }
    }

    
    
    public void simulate()
    {
        boolean flagDone = false;
        int jobsAdded = NumberofPrintJobs;
        
        while(flagDone == false)
        {
            
             currentTime++;  
            
           
            if(currentTime%100 == 0 && jobsAdded!= 0)
                {
                JobTime = randy.nextInt(990)+10;
                Waitqueue.insert(new Job(currentTime, JobTime));
                jobsAdded--;        
                }
            
            for(int i = 0 ; i < print.length; i++)
            {
                if(print[i].getvar()!= null)
                {
                    if(print[i].getvar().getTimeForJob()+print[i].getvar().getStartTime() == currentTime)
                        {
                        print[i].getvar().setEndTime(currentTime);
                        finishedQueue.insert(print[i].getvar());
                        
                       
                        print[i].setStartidletime(currentTime);
                         print[i].setvar(null);
                
                        }
                    
                
                }
            }
            
        
            for(int i = 0 ; i < print.length; i++)
            {
                if(print[i].getvar()==null)
                {
                    if(!Waitqueue.isEmpty())
                    {
                        print[i].settotalIdleTime(currentTime);
                        job = Waitqueue.remove();
                        print[i].setvar(job);
                        
                        print[i].getvar().setStartTime(currentTime);
                        print[i].setstartInUseTime(currentTime);
                        totalWaittime += print[i].getvar().getWaitTime();
                    }
                }
            }
            
            
           
            
            if(finishedQueue.size() == NumberofPrintJobs && Waitqueue.isEmpty() == true)
            {
                flagDone = true;
                for(int i = 0 ; i < print.length; i++)
                {
                    if(print[i].getvar()!= null)
                    {
                    flagDone=false;
                    }
                }
            }
            
            
          
           
    }
        
        displayStatistics();
}
    public void displayStatistics()
    {
        
        System.out.print("Simulation Results");
        System.out.print("\nSimulation with " + print.length + " printers lasted " + currentTime + " seconds processed " + NumberofPrintJobs);
        System.out.print("\nThe average wait time was: " + (double)totalWaittime/NumberofPrintJobs);
        System.out.print("\nPrinter Statistics:");
        System.out.println("\nName:     Job Processed:     Times In Use:        Time Idle");
        for(int i = 0; i < print.length; i++)
        {
            System.out.println(print[i].getprintName() + "      " + print[i].gettotalJobsProcessed()+ "              " + print[i].gettotalInUseTime() + "                  " + print[i].gettotalIdleTime());
            
        }
        System.out.print("\nJobs Statistics:");
        System.out.print("\nJob No.      Wait Time       Length of Job");
        for(int i=0; i< NumberofPrintJobs;i++)
        {
            jobRemove = finishedQueue.remove();
          System.out.print("\n"+ jobRemove.ID() + "            " + jobRemove.getWaitTime()+ "              " + jobRemove.getTimeForJob());
        }
    }
}
