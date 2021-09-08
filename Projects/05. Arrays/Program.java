import java.util.Scanner;

class Program {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int age0 = scanner.nextInt();
		int age1 = scanner.nextInt();
		int age2 = scanner.nextInt();
		int age3 = scanner.nextInt();
		int age4 = scanner.nextInt();
		int age5 = scanner.nextInt();

		double average = (age0 + age1 + age2 + age3 + age4 + age5) / 6.0;

		System.out.println(average);
	}
}