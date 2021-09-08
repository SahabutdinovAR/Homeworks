import java.util.Scanner;

class Program7 {
	public static void main(String[] args) {
		int numbers[] = {1, 7, 22, 28, 31, 33, 43, 55, 87, 99};
		
		Scanner scanner = new Scanner(System.in);
		int numberForSearch = scanner.nextInt();

		int left;
		int right;
		int middle;

		left = 0;
		right = numbers.length - 1;
		middle = left + (right - left) / 2;

		boolean isExists = false;

		while (left <= right) {

			// ---
			
			for (int i = 0; i < numbers.length; i++) {
				if (i == left) {
					System.out.print("[");
				}

				if (i == middle) {
					System.out.print("*");
				}

				System.out.print(" " + numbers[i] + " ");

				if (i == right) {
					System.out.print("]");
				}
			}

			System.out.println();

			// ---

			if (numbers[middle] < numberForSearch) {
				left = middle + 1;
				middle = left + (right - left) / 2;
			} else if (numbers[middle] > numberForSearch) {
				right = middle - 1;
				middle = left + (right - left) / 2;
			} else if (numbers[middle] == numberForSearch) {
				isExists = true;
				break;
			}
		}

		System.out.println(isExists);
	}
}