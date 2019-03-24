import java.util.Scanner;
/**
 * ReportDriver contains the main method for RaceReporter program. Initializes a scanner 'keyboard' for 
 * user input. 
 * 
 * Jakob Wilter
 * March 7, 2018
 * CSS 142
 */

public class ReportDriver {
    public static void main(String[] args) {
        String recordRace = "";
        Scanner keyboard = new Scanner(System.in);
        
        // After one iteration, user is provided with opportunity to enter another race report.
        // If user has no more inputs, ('n') will exit the system.
        do { 
            Race race = new Race();
            race.readInTimes();
            
            // Calls the writeReport method to output calculations, values and race rankings to console.
            RaceReport.writeReport(race);
            
            System.out.println("Enter another race? (y/n): ");
            recordRace = keyboard.nextLine();
        } while(!recordRace.equalsIgnoreCase("n"));
    }
}