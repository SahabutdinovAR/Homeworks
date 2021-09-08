import java.util.Scanner;

class Program3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int agesCount = scanner.nextInt();
		int ages[] = new int[agesCount];

		for (int i = 0; i < ages.length; i++) {
			ages[i] = scanner.nextInt();
		}

		double agesSum = 0;

		for (int i = 0; i < ages.length; i++) {
			agesSum += ages[i];
		}

		double average = agesSum / ages.length;

		System.out.println(average);

	}
}