/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
import java.util.Scanner;
public class printTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner console = new Scanner(System.in);
        System.out.print("Please Enter the Number of Printers: ");
        int NumofPrint = console.nextInt();
        System.out.print("\nPlease Enter the Number of Jobs: ");
        int NumofJobs = console.nextInt();
                
        PrintQueue var1 = new PrintQueue(NumofPrint,NumofJobs);
        var1.simulate();
    }
    
}
