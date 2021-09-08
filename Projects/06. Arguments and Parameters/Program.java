class Program {
	// x, y - parameters
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		// a, b - arguments
		swap(a, b);
		System.out.println(a + " " + b); // 10 5

		int numbers[] = {4, 5, 6};
		// numbers, 0, 2 - arguments
		swapInArray(numbers, 0, 2);

		System.out.println(numbers[0] + " " + numbers[2]);
	}

	// array, i, j - parameters
	public static void swapInArray(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}