package com.task.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task13 {
	public static void main(String[] args) {
		//paths
		String input = "C:/Users/User/Desktop/input.csv";
		String output = "C:/Users/User/Desktop/output.csv";

		// try catch with resource statement
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(input));
				FileWriter fileWriter = new FileWriter(output)) {
			String line;
			// loop for eof
			while ((line = bufferReader.readLine()) != null) {
				// excel csv split cell with ,
				String[] values = line.split(",");

				for (int i = 0; i < values.length; i++) {
					// append into new file
					fileWriter.append(values[i]);

					if (i != values.length - 1) {

						fileWriter.append(",");
					}

				}
				// new line for each line
				fileWriter.append("\n");
			}
			System.out.println("Data has been written to output.csv");

		} catch (IOException e) {

		}
	}
}