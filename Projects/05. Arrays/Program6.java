import java.util.Arrays;

class Program6 {
	public static void main(String[] args) {
		int[] array = {10, -5, 100, 11, -9, 12, -10, 58};

		int min;
		int indexOfMin;
		int temp;

		for (int i = 0; i < array.length; i++) {
			min = array[i];
			indexOfMin = i;

			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					indexOfMin = j;
				}
			}

			temp = array[i];
			array[i] = min;
			array[indexOfMin] = temp;
			System.out.println(Arrays.toString(array));
		}
	}
}