/**
 * The class  <b>BirthdayParadox</b> is used to
 * simulated the so-called Birthday paradox, and uses
 * the class <b>Statistics</b> to store the results of
 * the experiments.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

// Authors: Taha Khaldi and Omar Elboraey
// Student numbers: 8667551 and 8781712
// Course: ITI 1121-D & ITI 1521-A00
// Assignment: 2
// Question: 2

public class BirthdayParadox {

	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

	/** 
     * Runs the series of experiments, and stores the result into
     * a Statistics object
     * 
     * @param range the size of the set from which random number are drawn
     * @param numberOfRuns the number of experiments to run
	 *
	 * @return a reference to a Statistics instance that holds the result
	 * of the experiment
     */
 	public static Statistics runExperiments(int range, int numberOfRuns) {
 		Statistics statisticsObject = new Statistics(numberOfRuns);
 		for (int i = 0; i < numberOfRuns; i++) {
			statisticsObject.updateStatistics(oneRun(range));
		}
 		return statisticsObject;
	}

 	/** 
     * Runs a single experiment.
     * The parameter range defines the size of the set from which
     * the experiment is drawn
     * 
     * @param range the size of the set from which random number are drawn
     *
	 * @return the number of random draw in the set that the method 
	 * used before drawing the same element for the second time
     */
	private static int oneRun(int range) {
		int[] numbers = new int[range]; // initial value in each cell is zero
		int randomIndex;
 		int counter = 0;
 		
 		// loop until the random number appears twice
 		do {
 	 		randomIndex = generator.nextInt(range);
 			numbers[randomIndex]++;
 			counter++;
 		} while (numbers[randomIndex] <= 1);
 		
		return counter;
	}
	
     /** 
     * Main method. Runs the experiments numberOfRunstimes,
     * with increasingly large sets (increment in size:step).
     * Stop once the size reaches max.
     * plots the result.
     * 
     * @param args if not empty, contains the runtime values for
     * step, max and numberOfRuns
     */
	public static void main(String[] args) {
		
		// Default values
		int step = 100;
		int max = 10000;
		int numberOfRuns = 1000;
		
		int setSize = 0;
		
		// Check command-line arguments
		if (args.length < 3) {
			System.out.println("No arguments. Using default values.");
		} else {
			step = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
			numberOfRuns = Integer.parseInt(args[2]);
		}
		
                // Call the StudentInfo.java
        	StudentInfo.display();

		// Initialize chart object
		ITI1121Chart iChart = new ITI1121Chart("The Birthday Paradox Graph");
		
		// Main loop
		for (setSize += step; setSize <= max; setSize += step) {
			
			// Collect statistics for each run
			Statistics statistics = runExperiments(setSize, numberOfRuns);
			
			// Print statistics
			System.out.println(statistics);
			
			// Add point to graph
			iChart.addDataPoint(setSize, statistics.average(), statistics.standardDeviation());
		}
		
		// By trial and error, we want to add 3 curves to the graph:
		// one curve that seem to grow “like” our experiment:
		iChart.addPolynome(0.53);
		
		// ...another curve that grows slightly faster:
		iChart.addPolynome(0.56);
		
		// ...and another one that grows slightly slower:
		iChart.addPolynome(0.49);
		
		// Visualize the graph
		iChart.render();
	}

}
