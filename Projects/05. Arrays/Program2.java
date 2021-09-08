import java.util.Scanner;

class Program2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] ages = new int[6];

		/**
		ages[0] = 155;
		ages[1] = 167;
		ages[2] = 178;
		ages[3] = 199;
		ages[4] = 10;
		ages[5] = 777;
		**/

		for (int i = 0; i < 6; i++) {
			ages[i] = scanner.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(ages[i] + ", ");
		}
	}
}