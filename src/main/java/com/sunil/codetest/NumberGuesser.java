package com.sunil.codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;



public class NumberGuesser {

	/* To capture number of attempts*/
	private int numAttempts = 0;

	/**
	 * Reader to read user inputs
	 */
	private BufferedReader bufferedReader = null;

	/**
	 * Default Constructor - creates instance of a buffer reader to read user
	 * input
	 */
	public NumberGuesser() {
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
		} catch (final Exception ex) {
			System.err.println("Exception while creating a BufferedReader: "
					+ ex.getMessage());
		}
	}

	/**
	 * the  method that tries to 'guess' the number 
	 * uses binary search algorithm 
	 * Recursion is not used as it adds a stack-frame  for each guess
	 * Uses iteration instead
	 * Time Complexity O(log n) where n is the number of integers between maximum and minimum
	 * 
	 * @param lower
	 * @param higher
	 * @throws Exception
	 */
	public void guessNumber(int lower, int higher) throws IOException {
		

		while (true) {
			int guess = (lower + higher) / 2;
			numAttempts++;
			// Binary search 
			System.out.println("Is the number - "
							+ guess
							+ "? (Please answer with HIGHER, LOWER, or YES):");
			
			String userResp = bufferedReader.readLine();
			
						
			
			if (userResp.equalsIgnoreCase(NumberGuesserConstants.HIGHER) ) {
				lower = guess + 1;
				
			} else if (userResp.equalsIgnoreCase(NumberGuesserConstants.LOWER)) {
				higher = guess - 1;
			} else if (userResp.equalsIgnoreCase(NumberGuesserConstants.YES) ) {
				System.out.println("Found it !!!");
				System.out.println("Number of attemts - " + numAttempts);
				break;
			}  else {
				System.out.println("Invalid input !!!");
			}
		}
	}

	/**
	 * Closes the buffered reader
	 */
	public void closeReader() {
		try {
			bufferedReader.close();
		} catch (final Exception ex) {
			System.err.println("Exception while closing the buffered reader");
		}
	}

	/**
	 * Main method to test the program
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		

			NumberGuesser numGuesser = new NumberGuesser();

			System.out.println("Choose a random number (integer) between"
					+ NumberGuesserConstants.MIN_NUMBER + " "
					+ NumberGuesserConstants.MAX_NUMBER);

			try {
			
				numGuesser.guessNumber(NumberGuesserConstants.MIN_NUMBER,
						NumberGuesserConstants.MAX_NUMBER);
			} catch (IOException e) {
				StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter(writer);
				e.printStackTrace(printWriter);
				printWriter.flush();
			} finally {
				numGuesser.closeReader();
			}

		
		
		
	}


}
