package com.task.basic;

import java.util.HashMap;

public class Task7 {
	public static void main(String[] args) {
		String data[] = { "Pen", "Cat", "Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow", "Pen", "Cat", "Dog",
				"Blue", "White", "Dog", "Pen", "Blue", "Yellow" };

		// declare hashmap
		HashMap<String, Integer> storeData = new HashMap<String, Integer>();

		for (String s : data) {
			// declare count data
			Integer itemCount = storeData.get(s);

			// check if null for first time
			if (itemCount == null) {
				storeData.put(s, 1);
			}
			// else increase the count and put
			else {
				storeData.put(s, ++itemCount);
			}
		}

		System.out.println(storeData);

	}
}
