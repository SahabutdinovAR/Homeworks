import java.util.Scanner;
import java.util.Arrays;

class Program8 {

	public static boolean isExists(int array[], int number, boolean isDebug) {
		int left;
		int right;
		int middle;

		left = 0;
		right = array.length - 1;
		middle = left + (right - left) / 2;

		boolean isExists = false;

		while (left <= right) {

			// ---
			
			if (isDebug) {
				printCurrentDebugLine(array, left, middle, right);
			}

			// ---

			if (array[middle] < number) {
				left = middle + 1;
				middle = left + (right - left) / 2;
			} else if (array[middle] > number) {
				right = middle - 1;
				middle = left + (right - left) / 2;
			} else if (array[middle] == number) {
				isExists = true;
				break;
			}
		}

		return isExists;
	}

	public static void printCurrentDebugLine(int array[], int left, int middle, int right) {
		for (int i = 0; i < array.length; i++) {
				if (i == left) {
					System.out.print("[");
				}

				if (i == middle) {
					System.out.print("*");
				}

				System.out.print(" " + array[i] + " ");

				if (i == right) {
					System.out.print("]");
				}
			}

		System.out.println();
	}

	public static void main(String[] args) {
		int numbers[] = {1, 7, 22, 28, 31, 33, 43, 55, 87, 99};
		
		System.out.println(Arrays.toString(numbers));
		System.out.println("-100 - " + isExists(numbers, -100, true));
		System.out.println("21 - " + isExists(numbers, 21, false));
		System.out.println("31 - " + isExists(numbers, 31, false));
		System.out.println("56 - " + isExists(numbers, 56, false));
		System.out.println("55 - " + isExists(numbers, 55, false));
		System.out.println("87 - " + isExists(numbers, 87, false));
		System.out.println("99 - " + isExists(numbers, 99, false));
		System.out.println("100 - " + isExists(numbers, 100, false));
	}
}