/**
 * The class  <b>Statistics</b> accumulates the results of
 * the experiments. It know ahead of time how many experiments
 * will be run, and provides at the end the min, the max, the
 * average and the standard deviation for the data.
 *
 * <b> this class should not use classes such as Array, 
 * Lists etc. </b> to store the data, only primitive types 
 * and java arrays.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

// Authors: Taha Khaldi and Omar Elboraey
// Student numbers: 8667551 and 8781712
// Course: ITI 1121-D & ITI 1521-A00
// Assignment: 2
// Question: 2

public class Statistics {
	private int numberOfRuns;
	private int currentElement;
	private int[] data;
	private int min = Integer.MAX_VALUE;
	private int max;
	
	private double avg;
	private double stdDev;

	/** 
     * Constructor.
     * 
     * @param numberOfRuns the number of experiments that will be run
     */
 	public  Statistics(int numberOfRuns) {
 		this.numberOfRuns = numberOfRuns;
 		this.data = new int[numberOfRuns];
 		this.currentElement = 0;
	}
	
	/** 
     * Updates statistics after one experiment.
     * This method cannot be called more times than the 
     * parameter that was passed in the constructor. If
     * it is, an error message should be printed and
     * no change should occur.
     *   @param value the result of the new experiment
     */
	public void updateStatistics(int value) {
		if (currentElement >= numberOfRuns) {
			System.out.println("Statistics is full!");
			return;
		}
		
		data[currentElement++] = value;
		
		// Find min and max
		if (value < min) {
			min = value;
		}
		if (value > max) {
			max = value;
		}
	}
	

	/** 
     *   @return the current average of the values passed
     * to the method updateStatistic
     */
	public double average() {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return (double) sum / numberOfRuns;
	}


	/** 
     *   @return the current standard deviation of the values passed
     * to the method updateStatistic
     */
	public double standardDeviation() {
		double sumSqr = 0;
		for (int i = 0; i < data.length; i++) {
			sumSqr += (data[i] - avg) * (data[i] - avg);
		}
		return Math.sqrt(sumSqr / numberOfRuns);
	}

	/** 
     *  @return Returns the complete statistics information:
     * current minimum, current maximum, current average and
     * current standard deviation. For the last two, only two 
     * digits decimals are shown
     */
	public String toString() {
		avg = average();
		stdDev = standardDeviation();
		return String.format("We have run %d experiments.\n"
				+ "the minimum was: %d\n"
				+ "the maximum was: %d\n"
				+ "the mean was: %.2f\n"
				+ "the standard deviation was: %.2f\n",
				numberOfRuns, min, max, avg, stdDev);
	}

}
