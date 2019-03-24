/**
 * RaceReport holds method containing logic for outputting race report to console. 
 * Implements if statement for cases in which racers tie for either first or second place. 
 * Uses raceTimes[] array to store times in ascending order from [0] to [x].
 * 
 * Jakob Wilter
 * March 7, 2018
 * CSS 142
 */

public class RaceReport {
    public static void writeReport (Race race) { //Displays the output onto the console
        double raceTimes[] = race.getTimes(); //Stores time into arrays
        System.out.println("First place (time in seconds): " + raceTimes[0]);
        System.out.println("Second place (time in seconds): " + raceTimes[1]);
        System.out.println("Third place (time in seconds): " + raceTimes[2]);

        if(raceTimes[0]== raceTimes [1] ){ //Tests for racers who tied for first.
            System.out.println("Two racers shared first place.");
        }
        else if (raceTimes[1] == raceTimes[2]){ //Tests for racers who tied second.
            System.out.println("Two racers shared second place.");
        }
        else { //Ouputs line to console notifying that no racers tied.
            System.out.println("No racers tied.");
        }

        System.out.println("The range is " + race.getRange());
        System.out.println("The average "+ race.getAverage());
    }
    
    //Method to test and output tracing variables.
    /**
    *public static void testVaruableValues(Race race) {
    *    double times[] = race.getTimes();
    *    System.out.println("Range: " + race.getRange());
    *    System.out.println("Average: " + race.getAverage());
    *    System.out.println("Times: " + race.getTimes());
    }
    */
}