import java.util.Scanner;
/**
 * Race contains methods readInTimes, sortTimeAscending, getters and a race constructor.
 * readInTimes contains logic allowing user to enter up to three race times, then calls 
 * sortTimeAscending to order times from least to greatest. 
 * 
 * Jakob Wilter
 * March 7, 2018
 * CSS 142
 */

public class Race {
    private double average;
    private double raceTimes[];
    private double range;
    
    public void readInTimes() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the race times (in seconds):");
        
        for(int i = 0; i < 3; i++) {
            raceTimes[i] = keyboard.nextDouble();
        }
        
        sortTimesAscending();
        range = raceTimes[2] - raceTimes[0];
    }


    public Race() {
        raceTimes = new double[3]; // Array size set to 3.
        for(int i = 0; i < 3; i++) {
            raceTimes[0] = 0;
        }
    }
    
    private void sortTimesAscending() {
        double temp; //temp variable to store values while ordering.
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
                if(this.raceTimes[j] < this.raceTimes[k]) {
                    temp = this.raceTimes[j];
                    this.raceTimes[j] = this.raceTimes[k];
                    this.raceTimes[k] = temp;
                }
            }
        }
    }
    
    public double getAverage() { //Returns average
        return (raceTimes[0] + raceTimes[1] + raceTimes[2]) / 3.0; //Divide by number of indexes in array (3).
    }
    
    public double getRange() { //Returns range of data set.
        return range;
    }

    public double[] getTimes() { //Returns times
        return raceTimes;
    }

    public void setTimes(double[] times) {
        this.raceTimes = raceTimes;
    }
}