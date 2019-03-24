/**
 * SkydiverCalculator program prompts user to enter information about skydiver x including mass,
 * cross-sectional area, drag coefficient, ending time, time step, and the filename for which the 
 * data will be outputted to.
 * 
 * @author Jakob Wilter
 * @date March 1, 2018
 */
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SkydiverCalculator {
    //File will print out a file of the data per second.
    public static void main(String calcuatingVelocity[]) {
        Scanner keyboard = new Scanner(System.in);
        PrintWriter consoleWriter = new PrintWriter(System.out);

        while(true){
            System.out.println("Enter the mass of the skydiver (kg):");
            double mass = keyboard.nextDouble();

            System.out.println("Enter the cross-sectional area of the skydiver (mˆ2):");
            double crossSection = keyboard.nextDouble();

            System.out.println("Enter the drag coefficient of the skydiver:");
            double dragCoeffecient = keyboard.nextDouble();

            System.out.println("Enter the ending time (sec):");
            double endTime = keyboard.nextDouble();

            System.out.println("Enter the time step (sec):");
            double timeInterval = keyboard.nextDouble();
            keyboard.nextLine(); 

            int size = (int) (endTime / timeInterval) + 1;
            double velocity[] = new double[size];
            double time[] = new double[size];
            time[0] = 0.0;
            velocity[0] = 0.0;
            int i = 1;

            // Prompt user for name of file where data is to be outputted.
            System.out.println("Enter the output filename:"); 
            String newFileName = keyboard.nextLine();

            System.out.println("Writing out file... Here are the first few lines:");

            //Calculate velocity at time 't' per time step.
            for(double t = timeInterval; t < endTime; t += timeInterval) {
                time[i] = t;
                velocity[i] = calculateVelocity(mass, crossSection, dragCoeffecient, t, 
                    timeInterval, velocity[i-1]);
                i++;
            }

            // Write results to file.
            BufferedWriter fileWriter;
            try {
                fileWriter = new BufferedWriter(new FileWriter(newFileName));

                int outputSize;
                if (velocity.length > time.length) {
                    outputSize = time.length;
                }
                else {    
                    outputSize = velocity.length;
                }

                // Writing to output file.
                printDetails(velocity, time, fileWriter, outputSize);  

                if(outputSize > 10) {
                    outputSize = 10;
                }

                // Writing to console
                printDetails(velocity, time, consoleWriter, outputSize); 
                consoleWriter.flush();

                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            /**
             * Testing variables:
             * testVariableValues(mass, crossSection, dragCoeffecient, timeStep);
             **/

            System.out.println("Enter another dive? y/n?");
            char dive = keyboard.next().charAt(0);
            // User is prompted to enter another dive. 'y' will allow for another dive entry.
            // 'n' will exit the program.
            if (dive =='n' || dive == 'N')
            {
                System.out.println("Thank you for using the program! Goodbye.");
                System.exit(0);
            }
        }
    }

    public static void printDetails(double velocity[], double time[], Writer outputWriter, 
        int size) throws IOException {      
        // Prints data collected to ouput file.
        for(int i = 1; i < size; i++) {
            outputWriter.append(String.format("%.3f", time[i]) + ", ");
            outputWriter.append(String.format("%.4f", velocity[i]) + "\n");
        }
    }

    public static double calculateVelocity(double mass, double crossSection,double dragCoeffecient, 
        double time, double timeInterval, double velocity) {
        // Calculates the velocity of the skydiver given the input variables from the user.
        double gravitationalForce = 9.81;
        double airDensity = 1.14;
        return velocity + (gravitationalForce - ((dragCoeffecient * crossSection * airDensity) / 
            (2 * mass)) * velocity * velocity) * timeInterval; //Velocity formula
    }

    public static void testVariableValues(double mass, double crossSection, double dragCoefficient, 
        double timeInterval) {
        // Method for testing tracing variables.
        System.out.println();
        System.out.println("Mass: " + mass + "Cross-section: " + crossSection + "Drag Coefficient: " + 
            dragCoefficient + "Time Step: " + timeInterval);
        System.out.println();
    }
}