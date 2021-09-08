import java.util.Scanner;
// print index of element or -1 if it not exists
class Program4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = {10, -5, 100, 11, 2, 12, 46, 58};

		int numberForSearch = scanner.nextInt();

		int index = -1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == numberForSearch) {
				index = i;
				break; // stop the for
			}
		}

		System.out.println(index);
	}
}