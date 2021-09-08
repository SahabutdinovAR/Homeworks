class Program5 {
	public static void main(String[] args) {
		int[] array = {10, -5, 100, 11, -9, 12, -10, 58};

		int min = array[0];
		// 1 ... size of array
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				System.out.println(array[i] + " < " + min);
				min = array[i];
			} else {
				System.out.println(array[i] + " > " + min);
			}
		}

		System.out.println(min);
	}
}