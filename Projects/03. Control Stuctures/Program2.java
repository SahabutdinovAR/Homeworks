import java.util.Scanner;

class Program2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		// 12345 = 1 + 2 + 3 + 4 + 5
		int sum = 0;

		while (number != 0) {
			sum = sum + number % 10;
			number = number / 10;
			System.out.println(number);
		}

		System.out.println(sum);	
	}
}