package com.task.basic;

public class Task4 {

	public static void main(String[] args) {
		fn1(5);
		fn2(6);
		fn3(5);

	}

	public static void fn1(int input) {
		System.out.println("\ni)\n");
		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void fn2(int input) {
		System.out.println("\nii)\n");
		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= input; j++) {
				if (j <= input - i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void fn3(int input) {
		System.out.println("\niii)\n");

		for (int i = input; i >= 1; i--) {
			for (int j = i; j <= input; j++) {
				System.out.print("  ");
			}
			for (int x = 1; x <= (2 * i - 1); x++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}

}
