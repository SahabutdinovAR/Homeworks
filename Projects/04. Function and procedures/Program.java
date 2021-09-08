import java.util.Scanner;

class Program {
	// function declare
	// int - return value type
	// number - parameter
	public static int calculateDigitsSum(int number) {
		int result = 0;

		while (number != 0) {
			result += number % 10;
			number = number / 10;
		}

		return result;
	}

	public static boolean isPrime(int number) {
		if (number == 1 || number == 2 || number == 3) {
			return true;
		}

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int currentNumber = scanner.nextInt();
		int count = 0;

		while (currentNumber != -1) {
			
			// call function
			// currentNumber - argument
			int digitsSum = calculateDigitsSum(currentNumber);

			if (isPrime(digitsSum)) {
				count++;
			}

			currentNumber = scanner.nextInt();
		}

		System.out.println(count);
	}
}